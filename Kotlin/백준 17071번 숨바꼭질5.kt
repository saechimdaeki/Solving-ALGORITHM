import java.util.*
import kotlin.system.exitProcess

fun main() {
    var (n,k)=System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    val dist=Array(500001){Array(2){-1}}
    var q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(n,0))
    dist[n][0]=0
    while (q.isNotEmpty())
    {
        val (now,t)=q.poll()
        for(i in intArrayOf(now+1,now-1,now*2))
        {
            if(i in 0 ..500000)
            {
                if(dist[i][1-t]==-1)
                {
                    dist[i][1-t]=dist[now][t]+1
                    q.offer(Pair(i,1-t))
                }
            }
        }
    }
    var answer=-1
    var t=0
    while (true)
    {
        k+=t
        if(k>500000)
            break
        if(dist[k][t%2]<=t){
            answer=t
            break
        }
        t++
    }
    println(answer)

}