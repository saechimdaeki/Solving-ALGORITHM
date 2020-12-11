package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var incoming:IntArray
private lateinit var outcoming:IntArray

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    incoming=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    outcoming=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val t=br.readLine().toInt()
    val f= br.readLine().toInt()
    val mcmf1=mcmf(2*n+2,2*n,2*n+1)
    val mcmf2=mcmf(2*n+2,2*n,2*n+1)
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            when {
                incoming[i]< outcoming[j] -> {
                    val diff= outcoming[j]- incoming[i]
                    when {
                        diff<t -> {
                            var temp= ( t-diff) * (t-diff)
                            when {
                                temp>f -> temp=f
                            }
                            mcmf1.add(i,n+j,1,temp)
                            mcmf2.add(i,n+j,1,-temp)
                        }
                        else -> {
                            mcmf1.add(i,n+j,1,0)
                            mcmf2.add(i,n+j,1,0)
                        }
                    }
                }
            }
        }
    }
    (0 until n).forEach { i ->
        mcmf1.add_from(i,1,0)
        mcmf1.add_sink(n+i,1,0)
        mcmf2.add_from(i,1,0)
        mcmf2.add_sink(n+i,1,0)
    }
    mcmf1.flow()
    mcmf2.flow()
    when {
        mcmf1.total_F!=n -> println(-1)
        else -> println("${mcmf1.total_c} ${-mcmf2.total_c}")
    }
}

internal class vtx(var vertex: Int, var distance: Int) :Comparable<vtx>{
    override fun compareTo(other: vtx): Int {
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

private class mcmf(var n: Int, var so: Int, var sink: Int) {
    inner class edge(var to: Int, var cap: Int, var cost: Int) {
        lateinit var edg:edge
    }

    var arr:Array<ArrayList<edge>>
    var dist:IntArray
    var check:BooleanArray
    var potent:IntArray
    var total_F=0
    var total_c=0

    init {
        arr= Array(n){ ArrayList<edge>() }
        check= BooleanArray(n)
        dist=IntArray(n)
        potent= IntArray(n)
    }

    fun add(u:Int, v:Int, cap:Int, cost:Int){
        val original=edge(v,cap,cost)
        val ref=edge(u,0,-cost)
        original.edg=ref
        ref.edg=original
        arr[u].add(original)
        arr[v].add(ref)
    }
    fun add_from(v:Int,cap:Int,cost:Int){
        add(so,v,cap,cost)
    }
    fun add_sink(u:Int,cap:Int,cost:Int){
        add(u,sink,cap,cost)
    }
    fun spfa():Boolean{
        check.fill(false)
        dist.fill(1000000000)
        dist[so]=0
        val q=LinkedList<Int>()
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
        for(i in 0 until n)
            potent[i]=dist[i]
        return true
    }
    fun dijk():Boolean{
        check.fill(false)
        dist.fill(1000000000)
        val from1=IntArray(n){-1}
        val from2=IntArray(n){-1}
        val q=PriorityQueue<vtx>()
        dist[so]=0
        q.offer(vtx(so,0))
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
                        q.offer(vtx(y,dist[y]))
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