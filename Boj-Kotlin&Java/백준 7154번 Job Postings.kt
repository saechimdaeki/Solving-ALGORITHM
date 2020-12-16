package 백준

import java.util.*
import kotlin.collections.ArrayList


/* 전형적인 MCMF */
private class Mcmf(var n: Int, var so: Int, var sink: Int){
    inner class edge(var to: Int, var cap: Int, var cost: Int) {
        lateinit var edg:edge
    }
    var arr:Array<ArrayList<edge>>
    var dist:IntArray
    var potent:IntArray
    var check:BooleanArray
    var total_F=0
    var total_c=0
    init{
        arr=Array(n){ ArrayList<edge>() }
        dist= IntArray(n)
        check= BooleanArray(n)
        potent= IntArray(n)
    }

    fun add(u: Int, v: Int, cap: Int, cost: Int){
        val ori=edge(v, cap, cost)
        val rev=edge(u, 0, -cost)
        ori.edg=rev
        rev.edg=ori
        arr[u].add(ori)
        arr[v].add(rev)
    }
    fun add_from_so(v: Int, cap: Int, cost: Int){
        add(so, v, cap, cost)
    }
    fun add_to_sink(u: Int, cap: Int, cost: Int){
        add(u, sink, cap, cost)
    }
    fun spfa():Boolean{
        check.fill(false)
        dist.fill(1000000000)
        dist[so]=0
        val q= LinkedList<Int>()
        q.offer(so)
        check[so]=true
        while (q.isNotEmpty()){
            val x=q.poll()
            check[x]=false
            (0 until arr[x].size).forEach { i ->
                val temp= arr[x][i]
                val y=temp.to
                when {
                    temp.cap>0 && dist[x]+temp.cost<dist[y] -> {
                        dist[y]=dist[x]+temp.cost
                        when {
                            !check[y] -> {
                                check[y]=true
                                q.offer(y)
                            }
                        }
                    }
                }
            }
        }
        (0 until n)
                .forEach { i ->
                    potent[i]=dist[i]
                }
        return true
    }
    fun dijk():Boolean{
        check.fill(false)
        dist.fill(1000000000)
        val from1=IntArray(n){-1}
        val from2=IntArray(n){-1}
        val q=PriorityQueue<vtx7154>()
        dist[so]=0
        q.offer(vtx7154(so, 0))
        while (q.isNotEmpty()){
            val x=q.poll().vertex
            if(check[x]) continue
            check[x]=true
            if(x==sink) continue
            (0 until arr[x].size).forEach { i ->
                val temp= arr[x][i]
                val y=temp.to
                when {
                    temp.cap>0 && dist[y]>dist[x]+temp.cost-potent[y]+potent[x] -> {
                        dist[y]=dist[x]+temp.cost-potent[y]+potent[x]
                        from1[y]=x
                        from2[y]=i
                        q.offer(vtx7154(y, dist[y]))
                    }
                }
            }
        }
        if(dist[sink]==1000000000) return false
        (0 until n)
                .asSequence()
                .filter { dist[it]!=1000000000 }
                .forEach { potent[it]+=dist[it] }
        var x=sink
        var c= arr[from1[x]][from2[x]].cap
        while (from1[x]!=-1){
            when {
                c> arr[from1[x]][from2[x]].cap -> c= arr[from1[x]][from2[x]].cap
            }
            x=from1[x]
        }
        x=sink
        while (from1[x]!=-1){
            val temp= arr[from1[x]][from2[x]]
            temp.cap-=c
            temp.edg.cap+=c
            total_c+=temp.cost*c
            x=from1[x]
        }
        total_F+=c
        return true
    }
    fun flow(){
        total_F=0
        total_c=0
        spfa()
        while (dijk()){

        }
    }
}

private class vtx7154(var vertex: Int, var distance: Int) :Comparable<vtx7154>{
    override fun compareTo(other: vtx7154): Int {
        return when {
            this.distance<other.distance -> -1
            this.distance==other.distance -> {
                when {
                    this.vertex<other.vertex -> -1
                    this.vertex > other.vertex -> 1
                    else -> 0
                }
            }
            else -> 1
        }
    }
}

fun main() {
    val sc=Scanner(System.`in`)
    val sat = arrayOf(intArrayOf(4, 3, 2, 1),
            intArrayOf(8, 7, 6, 5), intArrayOf(12, 11, 10, 9))
    while (sc.hasNextInt()){
        val m=sc.nextInt()
        val n=sc.nextInt()
        if(n+m==0) break
        val mcmf=Mcmf(n+m+2,n+m,n+m+1)
        (0 until m).forEach { i ->
            mcmf.add_to_sink(n+i,sc.nextInt(),0)
        }

        for(i in 0 until n){
            var y=sc.nextInt()
            val ch=IntArray(4)
            y--
            for(j in 0 until 4)
                ch[j]=sc.nextInt()
            mcmf.add_from_so(i,1,0)
            for(j in 0 until 4)
                mcmf.add(i,n+ch[j],1,-sat[y][j])
        }
        mcmf.flow()
        println("${-mcmf.total_c}")
    }
}