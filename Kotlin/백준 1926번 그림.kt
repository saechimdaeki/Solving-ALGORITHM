package boj14681kot

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Boolean>>
private var n1=0
private var m1=0
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var answer=0
private val list=ArrayList<Int>()
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n, m)=br.readLine().split(" ").map { it->it.toInt() }
    n1=n
    m1=m
    arr=Array(n){Array(m){0}}
    dist=Array(n){Array(m){false} }
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]==1 && !dist[i][j])
            {
                answer++
                bfs(i,j)
            }
        }
    }
    println("$answer")
    if(list.size==0)
        println("0")
    else
    println("${list.max()}")
}
private fun bfs(x:Int,y:Int)
{
    val q:Queue<Pair<Int,Int>> = LinkedList()
    q.offer(Pair(x,y))
    var cnt=1
    dist[x][y]=true
    while (q.isNotEmpty())
    {
        val (nowx, nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n1 && nexty in 0 until m1 )
            {
                if(!dist[nextx][nexty] && arr[nextx][nexty]==1)
                {
                   dist[nextx][nexty]=true
                    cnt++
                    q.offer(Pair(nextx,nexty))
                }
            }
        }
    }
    list.add(cnt)
}