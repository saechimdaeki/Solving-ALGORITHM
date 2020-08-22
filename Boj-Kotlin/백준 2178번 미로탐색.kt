package boj14681kot

import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Int>>
private lateinit var checked:Array<Array<Boolean>>
private var dx= arrayOf(1,-1,0,0)
private var dy= arrayOf(0,0,1,-1)
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n, m ) = br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(n){Array(m){0}}
    dist=Array(n){Array(m){0}}
    checked=Array(n){Array(m){false}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]-'0'
    }
    println(bfs(0,0,n,m))
}
private fun bfs(x:Int,y:Int,n1:Int,m1:Int):Int
{
    val q:Queue<Pair<Int,Int > > =LinkedList()
    q.offer(Pair(x,y))
    dist[x][y]=1
    checked[x][y]=true
    while(q.isNotEmpty())
    {
        val (nowx,nowy )=q.poll()
        for(i in 0 until 4)
        {
            val nextx=dx[i]+nowx
            val nexty=dy[i]+nowy
            if(nextx in 0 until n1 && nexty in 0 until m1)
            {
                if(arr[nextx][nexty]==1 && !checked[nextx][nexty])
                {
                    q.offer(Pair(nextx,nexty))
                    checked[nextx][nexty]=true
                    dist[nextx][nexty]=dist[nowx][nowy]+1
                }
            }
        }
    }
    return dist[n1-1][m1-1]
}