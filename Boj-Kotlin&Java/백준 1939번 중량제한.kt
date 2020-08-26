import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var visited:Array<Boolean>
private var right=0
private var left=0
private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt()}
    arr=Array(n+1){ ArrayList<Pair<Int,Int>> () }
    visited=Array(n+1){false}

    for(i in 0 until m)
    {
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
        arr[b].add(Pair(a,c))
        right= max(right,c)
    }
    val (start, end)=br.readLine().split(" ").map { it.toInt() }
    while(left<=right)
    {
        var mid=(left+right)/2
        if (possible(mid,start,end))
        {
            answer=mid
            left=mid+1
        }else
            right=mid-1
    }
    println(answer)
}
private fun possible(mid:Int,s:Int,e:Int):Boolean{
    visited.fill(element = false)
    val q=LinkedList<Int>()
    visited[s]=true
    q.offer(s)
    while(q.isNotEmpty())
    {
        var current=q.poll()
        if(current==e)
            return true
        for(i in 0 until arr[current].size)
        {
            val np=arr[current][i].first
            val nw=arr[current][i].second
            if(mid<=nw &&!visited[np])
            {
                visited[np]=true
                q.offer(np)
            }
        }
    }
    return false
}