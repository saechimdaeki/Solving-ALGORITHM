
import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val br=System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val mc=mcmf(2*(n+1)+1,0,2*(n+1))
    val temp=br.readLine().split(" ").map { it.toLong() }
    temp.indices.forEach { i ->
        mc.add(1,(2*(i+1)),1,temp[i])
    }
    (1 until n).forEach { i ->
        val s=StringTokenizer(br.readLine())
        (i+1 ..n).forEach { j ->
            val temp=s.nextToken().toLong()
            mc.add((i*2)+1,(2*j),1,temp)
        }
    }
    mc.add(0,1,k,0)
    (1..n).forEach { i ->
        mc.add((i*2),(i*2)+1,1,-mc.infinite)
        mc.add_sink((i*2)+1,1,0)
    }
    mc.add_sink(1,k,0)
    mc.flow()
    println("${mc.total_c+mc.infinite*n}")
}

class mcmf(var n: Int, var so: Int, var sink: Int){
    inner class edge(var to: Int, var cap: Int, var cost: Long) {
        lateinit var edg:edge
    }

    var arr:Array<ArrayList<edge>> = Array(n){ArrayList<edge>()}
    var dist=LongArray(n)
    var check=BooleanArray(n)
    var infinite=100000000000L
    var total_F=0
    var total_c=0L

    fun add(u:Int,v:Int,cap:Int,cost:Long){
        val ori=edge(v,cap,cost)
        val rev=edge(u,0,-cost)
        ori.edg=rev
        rev.edg=ori
        arr[u].add(ori)
        arr[v].add(rev)
    }
    fun add_source(v:Int,cap:Int,cost:Long){
        add(so,v,cap,cost)
    }
    fun add_sink(u:Int,cap:Int,cost:Long){
        add(u,sink,cap,cost)
    }

    fun spfa():Boolean{
        check.fill(false)
        dist.fill(infinite)
        val from1=IntArray(n){-1}
        val from2=IntArray(n){-1}
        dist[so]=0
        val q=LinkedList<Int>()
        q.offer(so)
        while (q.isNotEmpty()){
            val x=q.poll()
            check[x]=false
            for(i in 0 until arr[x].size){
                val e=arr[x][i]
                val y=e.to
                if(e.cap>0 && dist[x]+e.cost<dist[y]){
                    dist[y]=dist[x]+e.cost
                    from1[y]=x
                    from2[y]=i
                    if(!check[y]){
                        check[y]=true
                        q.offer(y)
                    }
                }
            }
        }
        when (infinite) {
            dist[sink] -> return false
            else -> {
                var x = sink
                var c = arr[from1[x]][from2[x]].cap
                while (from1[x] != -1) {
                    if (c > arr[from1[x]][from2[x]].cap)
                        c = arr[from1[x]][from2[x]].cap
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
            //
        }
    }

}