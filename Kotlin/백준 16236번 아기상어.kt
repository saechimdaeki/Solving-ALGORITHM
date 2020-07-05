package boj14681kot

import java.util.*
import kotlin.collections.ArrayList

private var n=0
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private lateinit var dist:Array<Array<Int>>
private lateinit var arr:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()

    arr=Array(n){Array(n){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt()}
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    var sharkx=0
    var sharky=0
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            if(arr[i][j]==9)
            {
                sharkx=i
                sharky=j
                arr[i][j]=0
            }
        }
    }
    var answer=0
    var nowsharksize=2
    var levelup=0
    while(true){
        val tmp= bfs(sharkx,sharky,nowsharksize) ?: break
        arr[tmp.second][tmp.third]=0
        answer+=tmp.first
        levelup++
        if(nowsharksize==levelup)
        {
            nowsharksize++
            levelup=0
        }
        sharkx=tmp.second
        sharky=tmp.third
    }
    println(answer)
}
private fun bfs(x:Int,y:Int,size:Int): Triple<Int, Int, Int>?
{
    val ans:ArrayList<Triple<Int,Int,Int>> = ArrayList() //dist,x,y
    dist=Array(n){Array(n){-1}}
    dist[x][y]=0
    val q:Queue<Pair<Int,Int>> = LinkedList()
    q.offer(Pair(x,y))
    while(q.isNotEmpty())
    {
        val (nowx, nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n && nexty in 0 until n && dist[nextx][nexty]==-1)
            {
                var isok=false
                var caneat=false
                when {
                    arr[nextx][nexty]==0 -> isok=true
                    arr[nextx][nexty]<size -> {
                        isok=true
                        caneat=true
                    }
                    arr[nextx][nexty]==size -> {
                        isok=true
                    }
                }
                if(isok)
                {
                    q.offer(Pair(nextx,nexty))
                    dist[nextx][nexty]=dist[nowx][nowy]+1
                    if(caneat)
                        ans.add(Triple(dist[nextx][nexty],nextx,nexty))
                }
            }
        }
    }
    if(ans.isEmpty())
        return null
    var tmp=ans[0]
    for(i in ans)
    {
        if(tmp.first>i.first)
            tmp=i
        else if(tmp.first== i.first && tmp.second>i.second)
            tmp=i
        else if(tmp.first==i.first && tmp.second== i.second &&  tmp.third>i.third)
            tmp=i
    }
    return tmp
}