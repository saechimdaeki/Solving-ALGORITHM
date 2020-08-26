package boj14681kot

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Array<Int>>
private val dx= arrayOf(1,-1,0,0)
private val dy= arrayOf(0,0,1,-1)
private var cnt=0
private val q:Queue<Pair<Int,Int>> =LinkedList()
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (m, n)=br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(n){Array(m){0}}
    checked=Array(n){Array(m){-1}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        for(j in 0 until m) {
            arr[i][j] = input[j].toInt()

            if(arr[i][j]==1)
            {
                q.offer(Pair(i,j))
                checked[i][j]=0
            }
        }
    }
    while(q.isNotEmpty())
    {
        val(nowx, nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=dx[i]+nowx
            val nexty=dy[i]+nowy
            if(nextx in 0 until n && nexty in 0 until m)
            {
                if(arr[nextx][nexty]==0 && checked[nextx][nexty]==-1)
                {
                    checked[nextx][nexty]= checked[nowx][nowy]+1
                    q.offer(Pair(nextx,nexty))
                }
            }
        }
    }
    val list=ArrayList<Int>()
    for( i in 0 until n)
    {
        for(j in 0 until m)
            list.add(checked[i][j])
    }
    var answer:Int=list.max()!!
    for(i in 0 until n)
        for(j in 0 until m)
            if(arr[i][j]==0 && checked[i][j]==-1)
                answer=-1
    println(answer)
}