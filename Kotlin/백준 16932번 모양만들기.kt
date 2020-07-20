import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var arr:Array<Array<Int>>
private val groupd=Array(1000){Array(1000){0}}
private var dx= intArrayOf(0,0,1,-1)
private var dy= intArrayOf(1,-1,0,0)
private var answer=0
private val groupsize=Array(1000*1000){0}
private var globaln=0
private var globalm=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){Array(m+1){0}}
    globaln=n
    globalm=m
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]==1 && groupd[i][j]==0)
                bfs(i,j)
        }
    }
    var answer=0
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]==0)
            {
                var list=ArrayList<Int>()
                for(k in 0 until 4)
                {
                    var nextx=i+dx[k]
                    var nexty=j+dy[k]
                    if(nextx in 0 until n && nexty in 0 until m)
                    {
                        if(arr[nextx][nexty]==1)
                            list.add(groupd[nextx][nexty])
                    }
                }
                val set=list.distinct().toList().sorted()
                var sum=1
                for(k in set)
                    sum+=groupsize[k]
                answer=max(answer,sum)
            }
        }
    }
    println(answer)
}
private fun bfs(x:Int,y:Int){
    val q=LinkedList<Pair<Int,Int>>()
    answer++
    q.offer(Pair(x,y))
    groupd[x][y]=answer
    var cnt=1
    while (q.isNotEmpty())
    {
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until globaln &&nexty in 0 until globalm)
            {
                if(arr[nextx][nexty]==1 && groupd[nextx][nexty]==0) {
                    groupd[nextx][nexty] = answer
                    q.offer(Pair(nextx, nexty))
                    cnt++
                }
            }
        }
    }
    groupsize[answer]=cnt
}