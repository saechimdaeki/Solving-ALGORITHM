package boj14681kot

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var checked:Array<Int>
private lateinit var dist:Array<Int>
private var n=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    n=br.readLine().toInt()
    arr=Array(n){ ArrayList<Int>() }
    dist=Array(n){0}
    checked=Array(n){0}
    for(i in 0 until n)
    {
        val (from, to)=br.readLine().split(" ").map { it->it.toInt()-1 }
        arr[from].add(to)
        arr[to].add(from)
    }
    dfs(0,-1)
    val q:Queue<Int> = LinkedList()
    for(i in 0 until n)
    {
        if(checked[i]==2)
        {
            dist[i]=0
            q.offer(i)
        }else
            dist[i]=-1
    }
    while (q.isNotEmpty())
    {
        val x=q.poll()
        for(y in arr[x])
        {
            if(dist[y]==-1)
            {
                q.offer(y)
                dist[y]=dist[x]+1
            }
        }
    }
    for(i in 0 until n)
        bw.write("${dist[i]} ")
    bw.flush()
}
private fun dfs(x:Int,y:Int):Int{
    if(checked[x]==1)
        return x
    checked[x]=1
    for(i in arr[x])
    {
        if(i==y)
            continue
        val res=dfs(i,x)
        if(res==-2)
            return -2
        if(res>=0)
        {
            checked[x]=2
            return if(x==res)
                -2
            else res
        }
    }
    return -1
}