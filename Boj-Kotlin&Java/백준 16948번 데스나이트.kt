package boj14681kot

import java.util.*

private val dx= intArrayOf(-2,-2,0,0,2,2)
private val dy= intArrayOf(-1,1,-2,2,-1,1)

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val (r1, c1, r2, c2) =br.readLine().split(" ").map { it->it.toInt() }
    val q:Queue<Pair<Int,Int>> =LinkedList()
    q.offer(Pair(r1,c1))
    val dist=Array(n){Array(n){-1}}
    dist[r1][c1]=0
    while(q.isNotEmpty())
    {
        val now=q.poll()
        for(i in 0 until 6)
        {
            val x=now.first+dx[i]
            val y=now.second+dy[i]
            if(x>n || x<0 || y>n ||y<0)
                continue
            if(x in 0 until n && y in 0 until n)
            {
                if(dist[x][y]==-1)
                {
                    dist[x][y]=dist[now.first][now.second]+1
                    q.offer(Pair(x,y))
                }
            }
        }
    }
    println(dist[r2][c2])
}