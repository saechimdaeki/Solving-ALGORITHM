package boj14681kot

import java.util.*

private val visited=Array(1000000){false}
private lateinit var arr:Array<Int>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n , k)=br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(1000000){-1}
    visited[n]=true
    arr[n]=0
    val q:Queue<Int> = LinkedList()
    q.offer(n)
    while(q.isNotEmpty())
    {
        val now=q.poll()
        if(now-1>=0)
        {
            if(!visited[now-1])
            {
                q.offer(now-1)
                visited[now-1]=true
                arr[now-1]=arr[now]+1
            }
        }
        if(now+1<1000000)
        {
            if(!visited[now+1])
            {
                q.offer(now+1)
                visited[now+1]=true
                arr[now+1]=arr[now]+1
            }
        }
        if(now*2<1000000)
        {
            if(!visited[now*2])
            {
                q.offer(now*2)
                visited[now*2]=true
                arr[now*2]=arr[now]+1
            }
        }
    }
    println(arr[k])
}