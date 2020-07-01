package boj14681kot

import java.util.*

private val dx= arrayOf(0,0,1,-1)
private val dy= arrayOf(1,-1,0,0)
private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Array<Boolean>>
private lateinit var dist:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (m,n)=br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(n){Array(m){0}}
    checked=Array(n){Array(m){false}}
    dist=Array(n){Array(m){-1}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
        {
            arr[i][j]=input[j]-'0'
        }
    }
    val q:Deque<Pair<Int,Int> > = LinkedList()
    q.offer(Pair(0,0))
    dist[0][0]=0
    while(q.isNotEmpty())
    {
        val (nowx, nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n && nexty in 0 until m)
            {
                if(dist[nextx][nexty]==-1)
                {
                    if(arr[nextx][nexty]==0)
                    {
                        dist[nextx][nexty]=dist[nowx][nowy]
                        q.offerFirst(Pair(nextx,nexty))
                    }else{
                        dist[nextx][nexty]=dist[nowx][nowy]+1
                        q.offerLast(Pair(nextx,nexty))
                    }
                }
            }
        }
    }
    println("${dist[n-1][m-1]}")
}