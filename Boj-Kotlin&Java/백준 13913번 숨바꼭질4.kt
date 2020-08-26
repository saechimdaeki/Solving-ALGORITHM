package boj14681kot

import java.util.*

private val visited=Array(1000000){false}
private val arr=Array(1000000){0}
private val from=Array(1000000){0}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,k)=br.readLine().split(" ").map { it->it.toInt() }
    visited[n]=true
    arr[n]=0
    val q:Queue<Int> = LinkedList()
    q.offer(n)
    val stack:Stack<Int> = Stack()
    while(q.isNotEmpty())
    {
        val now=q.poll()

        if(now==k)
        {
            var tmp=now
            while(tmp!=n)
            {
                stack.push(tmp)
                tmp=from[tmp]
            }
            stack.push(n)
            break
        }


        if(now-1>=0)
        {
            if(!visited[now-1])
            {
                q.offer(now-1)
                visited[now-1]=true
                arr[now-1]=arr[now]+1
                from[now-1]=now
            }
        }
        if(now+1<100000)
        {
            if(!visited[now+1])
            {
                q.offer(now+1)
                visited[now+1]=true
                arr[now+1]=arr[now]+1
                from[now+1]=now
            }
        }
        if(now*2<1000000)
        {
            if(!visited[now*2])
            {
                q.offer(now*2)
                visited[now*2]=true
                arr[now*2]=arr[now]+1
                from[now*2]=now
            }
        }
    }
    bw.write("${arr[k]}\n")
    while (stack.isNotEmpty())
    {
        bw.write("${stack.pop()} ")
    }
    bw.flush()
}