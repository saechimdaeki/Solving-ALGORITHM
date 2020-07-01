package boj14681kot

import java.util.*

private val dx= arrayOf(0,0,1,-1)
private val dy= arrayOf(1,-1,0,0)
private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Int>>
private lateinit var grouped:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    dist=Array(n){Array(n){0}}
    grouped=Array(n){Array(n){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        for(j in input.indices)
            arr[i][j]=input[j].toInt()
    }
    var cnt=0
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            if(arr[i][j]==1 && grouped[i][j]==0)
            {
                val q:Queue<Pair<Int,Int> > = LinkedList()
                grouped[i][j]=++cnt
                q.offer(Pair(i,j))
                while(q.isNotEmpty())
                {
                    val (nowx,nowy)=q.poll()
                    for(i in 0 until 4)
                    {
                        val nextx=nowx+dx[i]
                        val nexty=nowy+dy[i]
                        if(nextx in 0 until n && nexty in 0 until n)
                        {
                            if(arr[nextx][nexty]==1 && grouped[nextx][nexty]==0)
                            {
                                q.offer(Pair(nextx,nexty))
                                grouped[nextx][nexty]=cnt
                            }
                        }
                    }
                }
            }
        }
    }
    val q:Queue<Pair<Int,Int> > =LinkedList()
    for(i in 0 until n)
    {
        for (j in 0 until n)
        {
            dist[i][j]=-1
            if(arr[i][j]==1)
            {
                q.offer(Pair(i,j))
                dist[i][j]=0
            }
        }
    }
    while(q.isNotEmpty())
    {
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n && nexty in 0 until n)
            {
                if(dist[nextx][nexty]==-1)
                {
                    dist[nextx][nexty]=dist[nowx][nowy]+1
                    grouped[nextx][nexty]= grouped[nowx][nowy]
                    q.offer(Pair(nextx,nexty))
                }
            }
        }
    }
    var answer=-1
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            for(k in 0 until 4)
            {
                val x=i+dx[k]
                val y=j+dy[k]
                if(x in 0 until n && y in 0 until n)
                {
                    if(grouped[i][j]!= grouped[x][y])
                    {
                        if(answer==-1 ||answer>dist[i][j]+dist[x][y])
                        answer=dist[i][j]+dist[x][y]
                    }
                }
            }
        }
    }
    println(answer)
}