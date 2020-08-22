import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var dist:Array<Array<Long>>
private lateinit var check:Array<Array<Boolean>>
private const val inf=1000000000*50000L //10억 *도로수 한계
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    dist=Array(n+1){Array(k+1){inf}}
    check=Array(n+1){Array(k+1){false}}
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
        arr[b].add(Pair(a,c))
    }
    dist[1][0]=0
    val q=PriorityQueue<node>()
    q.offer(node(0,1,0))
    while (q.isNotEmpty())
    {
        val (cost,vertex,step)=q.poll()
        if(check[vertex][step])
            continue
        check[vertex][step]=true
        for(tmp in arr[vertex])
        {
            if(step+1<=k && dist[tmp.first][step+1]>dist[vertex][step])
            {
                dist[tmp.first][step+1]=dist[vertex][step]
                q.offer(node(dist[tmp.first][step+1],tmp.first,step+1))
            }
            if(dist[tmp.first][step]>dist[vertex][step]+tmp.second){
                dist[tmp.first][step]=dist[vertex][step]+tmp.second
                q.offer(node(dist[tmp.first][step],tmp.first,step))
            }


        }

    }
    var answer=inf
    for(i in 1..k)
    {
        if(check[n][i]&&answer>dist[n][i])
            answer=dist[n][i]
    }
    println(answer)


}
private data class node(var cost:Long,var vertex:Int,var step:Int):Comparable<node>{
    override fun compareTo(other: node): Int {
        return when {
            cost<other.cost -> -1
            cost==other.cost -> 0
            else -> 1
        }
    }
}
