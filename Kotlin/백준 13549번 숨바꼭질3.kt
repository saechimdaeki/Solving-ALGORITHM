package boj14681kot

import java.util.*

private val visited=Array(1000000){false}
private val dist=Array(1000000){-1}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it->it.toInt() }
    visited[n]=true
    dist[n]=0
    var q:Deque<Int> = LinkedList()
    q.add(n)
    while(q.isNotEmpty())
    {
        val now= q.poll()
        val arr= arrayOf(now*2,now-1,now+1)
        for(i in arr)
        {
            if(i in 0..999999)
            {
                if(!visited[i])
                {
                    visited[i]=true
                    if(i==now*2)
                    {
                        q.offerFirst(i)
                        dist[i]=dist[now]
                    }else{
                        q.addLast(i)
                        dist[i]= dist[now]+1
                    }
                }
            }
        }
    }
    println(dist[k])
}