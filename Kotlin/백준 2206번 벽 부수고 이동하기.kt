package boj14681kot

import java.util.*
import kotlin.math.min

private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Array<Int>>>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m) =br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(n){Array(m){0}}
    dist=Array(n){Array(m){Array(2){0}}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]-'0'
    }
    dist[0][0][0]=1
    val q:Queue<Triple<Int,Int,Int>> =LinkedList()
    q.offer(Triple(0,0,0))
    while(q.isNotEmpty())
    {
        val (x,y,z)=q.poll()
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx in 0 until n && ny in 0 until m)
            {
                if(arr[nx][ny]==0 && dist[nx][ny][z]==0)
                {
                    dist[nx][ny][z]=dist[x][y][z]+1
                    q.offer(Triple(nx,ny,z))
                }
                if(z==0 && arr[nx][ny]==1 && dist[nx][ny][z+1]==0)
                {
                    dist[nx][ny][z+1]=dist[x][y][z]+1
                    q.offer(Triple(nx,ny,z+1))
                }
            }
        }
    }
    if(dist[n-1][m-1][0] !=0 && dist[n-1][m-1][1]!=0)
        println(min(dist[n-1][m-1][0],dist[n-1][m-1][1]))
    else if(dist[n-1][m-1][0]!=0)
        println(dist[n-1][m-1][0])
    else if(dist[n-1][m-1][1]!=0)
        println(dist[n-1][m-1][1])
    else
        println(-1)
}