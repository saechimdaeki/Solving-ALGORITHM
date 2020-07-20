import java.util.*

private lateinit var arr:Array<Int>
private lateinit var dist:Array<Int>
fun main() {
    val (F,S,G,U,D) =System.`in`.bufferedReader()
            .readLine().split(" ").map { it.toInt() }
    arr=Array(F+1){0}
    dist=Array(F+1){-1}
    dist[S]=0
    val q=LinkedList<Int>()
    q.offer(S)
    while (q.isNotEmpty())
    {
        //println("Gg")
        val now=q.poll()
        if(now+U <=F && dist[now+U]==-1)
        {
            dist[now+U]=dist[now]+1
            q.offer(now+U)
        }
        if(now-D>0 && dist[now-D]==-1)
        {
            dist[now-D]=dist[now]+1
            q.offer(now-D)
        }
    }
    if(dist[G]==-1)
        println("use the stairs")
    else{
        println("${dist[G]}")
    }
}