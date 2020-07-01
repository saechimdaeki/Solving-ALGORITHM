package boj14681kot

import java.util.*

private val dist=Array(1001){Array(1001){-1}}
private val q:Queue<Pair<Int, Int> > = LinkedList()
private var answer=-1
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val s=br.readLine().toInt()
    q.offer(Pair(1,0))
    while(q.isNotEmpty())
    {
        val (a, b)=q.poll()
        if(dist[a][a]==-1)
        {
            dist[a][a]=dist[a][b]+1
            q.offer(Pair(a,a))
        }
        if(a+b<=s && dist[a+b][b]==-1)
        {
            dist[a+b][b]=dist[a][b]+1
            q.offer(Pair(a+b,b))
        }
        if(a-1>=0 && dist[a-1][b]==-1)
        {
            dist[a-1][b]=dist[a][b]+1
            q.offer(Pair(a-1,b))
        }
    }
    for( i in 0..s)
    {
        if(dist[s][i]!=-1)
        {
            if(answer==-1 ||answer>dist[s][i])
                answer=dist[s][i]
        }
    }
    println(answer+1)
}
