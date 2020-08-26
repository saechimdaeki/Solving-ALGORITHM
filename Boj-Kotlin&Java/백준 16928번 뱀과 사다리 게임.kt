package boj14681kot

import java.util.*

private val dist=Array(101){-1}
private val arr=Array(101){0}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n, m)=br.readLine().split(" ").map { it->it.toInt() }
    for(i in 1..100)
        arr[i]=i
    for(i in 0 until n+m)
    {
        val (from, to)=br.readLine().split(" ")
        arr[from.toInt()]=to.toInt()
    }

    dist[1]=0
    val q:Queue<Int> =LinkedList()
    q.offer(1)
    while(q.isNotEmpty())
    {
        val now=q.poll()
        for(i in 1..6)
        {
            var next=now+i
            if(next>100)
                continue
            next=arr[next]
            if(dist[next]==-1)
            {
                dist[next]=dist[now]+1
                q.offer(next)
            }
        }
    }
    println(dist[100])
}