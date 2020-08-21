import java.util.*
import kotlin.collections.ArrayList

private lateinit var visited:Array<Boolean>
private lateinit var list:Array<ArrayList<Pair<Int,Int>>>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,Q)=br.readLine().split(" ").map { it.toInt() }
    visited=Array(n+1){false}
    list= Array(n+1){ arrayListOf<Pair<Int,Int>>()}
    repeat(n-1){
        val (p,q,r)=br.readLine().split(" ").map { it.toInt() }
        list[p].add(Pair(q,r))
        list[q].add(Pair(p,r))
    }
    for(i in 0 until Q)
    {
        var answer=0
        val (k,v)=br.readLine().split(" ").map { it.toInt() }
        visited.fill(element = false)
        visited[v]=true
        val q=LinkedList<Int>()
        q.offer(v)
        while (q.isNotEmpty())
        {
            val now=q.poll()
            for(j in 0 until list[now].size)
            {
                val nx=list[now][j].first
                val nvalue=list[now][j].second
                if(!visited[nx] && nvalue>=k){
                    visited[nx]=true
                    answer++
                    q.offer(nx)
                }
            }
        }
        bw.write("${answer}\n")
    }
    bw.flush()
}