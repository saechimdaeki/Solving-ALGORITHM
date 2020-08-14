import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,k)=br.readLine().split(" ").map{it.toInt()}
    val visited=Array(100001){false}
    val dist=Array(100001){0}
    val cnt=Array(100001){0}
    val q=LinkedList<Int>()
    q.offer(n)
    visited[n]=true
    dist[n]=0
    cnt[n]=1
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(next in arrayListOf(now-1,now+1,now*2))
        {
            if(next in 0..100000)
            {
                if(!visited[next])
                {
                    q.offer(next)
                    visited[next]=true
                    dist[next]=dist[now]+1
                    cnt[next]=cnt[now]
                }else if(dist[next]==dist[now]+1)
                    cnt[next]+=cnt[now]
            }
        }
    }
    bw.write("${dist[k]}\n")
    bw.write("${cnt[k]}\n")
    bw.flush()
}