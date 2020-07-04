package boj14681kot

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

private val dx= intArrayOf(0,0,1,-1,1,-1,1,-1,0)
private val dy= intArrayOf(1,-1,0,0,1,1,-1,-1,0)
private val list=Array(8){Array(8){' '}}
private var possible=false
private val visited=Array(8){Array(8){Array(9){false}}}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    for(i in 0 until 8)
    {
        val input=br.readLine()
        for(j in input.indices)
            list[i][j]=input[j]
    }
    bfs(7,0,0)
    if(possible)
        println(1)
    else
        println(0)

}
private fun bfs(x:Int,y:Int,z:Int)
{
    val q:Queue<Triple<Int,Int,Int>> = LinkedList()
    q.offer(Triple(x,y,z))
    visited[x][y][z]=true
    while(q.isNotEmpty())
    {
        val (nowx, nowy, nowz) = q.poll()
        if(nowx==0 && nowy==7)
        {
            possible=true
            return
        }
        for(i in 0 until 9)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            var nextz= min(8,nowz+1)
            if(nextx in 0 until 8 && nexty in 0 until 8) {
                if (nextx - nowz >= 0 && list[nextx - nowz][nexty] == '#')
                    continue
                if (nextx - nowz - 1 >= 0 && list[nextx - nowz - 1][nexty] == '#')
                    continue
                if (!visited[nextx][nexty][nextz]) {
                    visited[nextx][nexty][nextz] = true
                    q.offer(Triple(nextx, nexty, nextz))
                }
            }
        }

    }
}