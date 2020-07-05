package boj14681kot

import java.util.*

private lateinit var charr:Array<Array<Char>>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var startx=-123
private var starty=-123
private var endx=-123
private var endy=-123
private lateinit var dist:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val(w, h)=br.readLine().split(" ").map { it->it.toInt() }
    charr=Array(h){Array(w){' '}}
    dist=Array(h){Array(w){-1}}
    for(i in 0 until h)
    {
        val input=br.readLine()
        for(j in input.indices)
            charr[i][j]=input[j]
    }
    for(i in 0 until h)
    {
        for(j in 0 until w)
        {
            if(charr[i][j]=='C') {
                if (startx == -123) {
                    startx = i
                    starty = j
                } else {
                    endx = i
                    endy = j
                }
            }
        }
    }
    val q:Queue<Pair<Int, Int>> = LinkedList()
    q.offer(Pair(startx, starty))
    dist[startx][starty]=0
    while(q.isNotEmpty())
    {
        val (x, y)=q.poll()
        for(i in 0 until 4)
        {
            var nextx=x+dx[i]
            var nexty=y+dy[i]
            while(nextx in 0 until h && nexty in 0 until w)
            {
                if(charr[nextx][nexty]=='*')
                    break
                if(dist[nextx][nexty]==-1)
                {
                    dist[nextx][nexty]=dist[x][y]+1
                    q.offer(Pair(nextx,nexty))
                }
                nextx+=dx[i]
                nexty+=dy[i]
            }
        }
    }
    println(dist[endx][endy]-1)
}