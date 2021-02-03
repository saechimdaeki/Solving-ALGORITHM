import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val a=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m=mcmf(2*n+2,2*n,2*n+1)
    for(i in 0 until n){
        m.add_source(i,1,0)
        m.add_sink(n+i,1,0)
    }
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            when {
                a[i]>b[j] -> m.add(i,n+j,1,-2)
                a[i]==b[j] -> m.add(i,n+j,1,-1)
                else -> m.add(i,n+j,1,0)
            }
        }
    }
    m.flow()
    println(-m.total_c)
}
class mcmf(var n:Int,var so:Int,var sink:Int){
    inner class edge(var to: Int, var cap: Int, var cost: Int) {
        lateinit var edg:edge
    }
    var arr:Array<ArrayList<edge>> = Array(n){ ArrayList<edge>() }
    var dist:IntArray = IntArray(n)
    var potent:IntArray = IntArray(n)
    var check:BooleanArray = BooleanArray(n)
    var total_F=0
    var total_c=0

    fun add(u:Int,v:Int,cap:Int,cost:Int){
        val ori=edge(v,cap,cost)
        val rev=edge(u,0,-cost)
        ori.edg=rev
        rev.edg=ori
        arr[u].add(ori)
        arr[v].add(rev)
    }
    fun add_source(v:Int,cap:Int,cost:Int){
        add(so,v,cap,cost)
    }

    fun add_sink(u:Int,cap:Int,cost:Int){
        add(u,sink,cap,cost)
    }

    fun spfa():Boolean{
        check.fill(false)
        dist.fill(1000000)
        val from1=IntArray(n){-1}
        val from2=IntArray(n){-1}
        dist[so]=0
        val q=LinkedList<Int>()
        q.offer(so)
        while (q.isNotEmpty()){
            val x=q.poll()
            check[x]=false
            (0 until  arr[x].size).forEach { i ->
                val e= arr[x][i]
                val y=e.to
                when {
                    e.cap>0 &&dist[x]+e.cost<dist[y] -> {
                        dist[y]=dist[x]+e.cost
                        from1[y]=x
                        from2[y]=i
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
        when {
            dist[sink]==1000000 -> {
                return false
            }
            else -> {
                var x = sink
                var c = arr[from1[x]][from2[x]].cap
                while (from1[x] != -1) {
                    when {
                        c > arr[from1[x]][from2[x]].cap -> {
                            c = arr[from1[x]][from2[x]].cap
                        }
                    }
                    x = from1[x]
                }
                x = sink
                while (from1[x] != -1) {
                    val e = arr[from1[x]][from2[x]]
                    e.cap -= c
                    e.edg.cap += c
                    x = from1[x]
                }
                total_F += c
                total_c += c * dist[sink]
                return true
            }
        }
    }
    fun flow(){
        total_F=0
        total_c=0
        while (spfa()){

        }
    }
}