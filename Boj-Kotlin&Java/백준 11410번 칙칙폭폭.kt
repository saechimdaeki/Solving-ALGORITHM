package 백준

import java.util.*
import kotlin.collections.ArrayList

private class MCMF11410(var n:Int, var so:Int, var sink:Int){
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
        val q=PriorityQueue<vtx11410>()
        dist[so]=0
        q.offer(vtx11410(so, 0))
        loop@ while (q.isNotEmpty()){
            val x=q.poll().vertex
            when {
                check[x] -> continue@loop
            }
            check[x]=true
            when (x) {
                sink -> continue@loop
            }
            (0 until arr[x].size).forEach { i ->
                val temp= arr[x][i]
                val y=temp.to
                when {
                    temp.cap>0 && dist[y]>dist[x]+temp.cost-potent[y]+potent[x] -> {
                        dist[y]=dist[x]+temp.cost-potent[y]+potent[x]
                        from1[y]=x
                        from2[y]=i
                        q.offer(vtx11410(y, dist[y]))
                    }
                }
            }
        }
        when {
            dist[sink]==1000000000 -> return false
            else -> {
                (0 until n)
                        .asSequence()
                        .filter { dist[it] != 1000000000 }
                        .forEach { potent[it] += dist[it] }
                var x = sink
                var c = arr[from1[x]][from2[x]].cap
                while (from1[x] != -1) {
                    when {
                        c > arr[from1[x]][from2[x]].cap -> c = arr[from1[x]][from2[x]].cap
                    }
                    x = from1[x]
                }
                x = sink
                while (from1[x] != -1) {
                    val temp = arr[from1[x]][from2[x]]
                    temp.cap -= c
                    temp.edg.cap += c
                    total_c += temp.cost * c
                    x = from1[x]
                }
                total_F += c
                return true
            }
        }
    }
    fun flow(){
        total_F=0
        total_c=0
        spfa()
        while (dijk()){}
    }

}

private class vtx11410(var vertex: Int, var distance: Int) :Comparable<vtx11410>{
    override fun compareTo(other: vtx11410): Int {
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

private fun calc(x:Int,y:Int,n:Int):Int{
    return n+(n-1)*n/2 - (n-x-1)*(n-x)/2 + (y-x-1)
}
private lateinit var arr:Array<IntArray>
private lateinit var brr:Array<IntArray>
fun main() {
    val sc=Scanner(System.`in`)
    val n=sc.nextInt()
    val p =sc.nextInt()
    arr=Array(n){ IntArray(n) }
    brr=Array(n){ IntArray(n) }
    (0 until n-1)
            .forEach { i ->
                (i+1 until n)
                        .forEach { j ->
                            arr[i][j]=sc.nextInt()
                        }
            }
    (0 until n-1)
            .forEach { i ->
                (i+1 until n)
                        .forEach { j ->
                            brr[i][j]=sc.nextInt()
                        }
            }
    val t=n+(n-1)*n/2 +2
    val mcmf=MCMF11410(t,t-2,t-1)
    (0 until n-1)
            .forEach { i ->
                mcmf.add(i,i+1,p,0)
            }
    val a=IntArray(n)
    (0 until n-1)
            .forEach { i ->
                (i+1 until n).forEach { j ->
                    mcmf.add_from_so(calc(i,j,n),arr[i][j],0)
                    mcmf.add(calc(i,j,n),i,arr[i][j],-brr[i][j])
                    mcmf.add(calc(i,j,n),j,arr[i][j],0)
                    a[j]+=arr[i][j]
                }
            }
    (1 until n)
            .forEach { i ->
                mcmf.add_to_sink(i,a[i],0)
            }
    mcmf.flow()
    println(-mcmf.total_c)
}