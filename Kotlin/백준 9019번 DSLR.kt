package boj14681kot

import java.lang.StringBuilder
import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var t=br.readLine().toInt()
    while (t-- > 0)
    {
        var (start, finish) = br.readLine().split(" ").map { it->it.toInt() }
        val checked=BooleanArray(10001)
        val dist=Array(10001){0}
        val method=Array(10001){' '}
        val from=Array(10001){0}
        checked[start]=true
        from[start]=-1
        val q:Queue<Int> = LinkedList()
        q.offer(start)
        while(q.isNotEmpty())
        {
            val now=q.poll()
            var next=(now*2)%10000
            if(!checked[next])
            {
                q.offer(next)
                checked[next]=true
                dist[next]=dist[now]+1
                from[next]=now
                method[next]='D'
            }
            next=now-1
            if(next==-1)
                next=9999
            if(!checked[next])
            {
                q.offer(next)
                checked[next]=true
                dist[next]=dist[now]+1
                from[next]=now
                method[next]='S'
            }
            next=(now%1000)*10 +now/1000
            if(!checked[next])
            {
                q.offer(next)
                checked[next]=true
                dist[next]=dist[now]+1
                from[next]=now
                method[next]='L'
            }
            next=(now/10)+(now%10)*1000
            if(!checked[next])
            {
                q.offer(next)
                checked[next]=true
                dist[next]=dist[now]+1
                from[next]=now
                method[next]='R'
            }
        }
        var s=StringBuilder()
        while(finish!=start)
        {
            s.append(method[finish])
            finish=from[finish]
        }
        println(s.reverse())
    }

}