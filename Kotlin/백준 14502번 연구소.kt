package boj14681kot

import java.util.*
import kotlin.math.max

private lateinit var grid:Array<Array<Int>>
private lateinit var state:Array<Array<Int>>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var answer=0
private var n=0
private var m=0
private val q:Queue<Pair<Int,Int>> =LinkedList()
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n1, m1)=br.readLine().split(" ").map { it->it.toInt() }
    n=n1
    m=m1
    grid=Array(n){Array(m){0}}
    state=Array(n){Array(m){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt() }
        for(j in input.indices)
            grid[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(grid[i][j]==0)
            {
                for(k in 0 until n)
                {
                    for(t in 0 until m)
                        state[k][t]=grid[k][t]
                }
                state[i][j]=1
                wall(1)
                state[i][j]=0
            }
        }
    }
    println(answer)
}
private fun wall(x:Int){
    if(x==3)
    {
        spread()
        return
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(state[i][j]==0) {
                state[i][j] = 1
                wall(x + 1)
                state[i][j] = 0
            }
        }
    }
}
private fun spread()
{
    val afterstate=Array(n){Array(m){0} }
    for(i in 0 until n)
        for(j in 0 until m)
            afterstate[i][j]= state[i][j]
    for(i in 0 until n )
    {
        for(j in 0 until m)
        {
            if(afterstate[i][j]==2)
                q.offer(Pair(i,j))
        }
    }
    while(q.isNotEmpty())
    {
        val (x, y)=q.poll()
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx in 0 until n && ny in 0 until m)
            {
                if(afterstate[nx][ny]==0)
                {
                    afterstate[nx][ny]=2
                    q.offer(Pair(nx,ny))
                }
            }
        }
    }
    var cnt=0
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(afterstate[i][j]==0)
                cnt++
        }
    }
    answer= max(answer,cnt)
}