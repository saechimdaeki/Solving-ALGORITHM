package boj14681kot

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min


private lateinit var list:Array<ArrayList<Int>>
private lateinit var visit:Array<Boolean>
private var answer=0
private var cnt=0
private var minhutgan=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n, m)=br.readLine().split(" ").map { it.toInt() }
    list=Array(n+1){ ArrayList<Int>()}
    visit=Array(n+1){false}
    for(i in 0 until m)
    {
        val (from,to)=br.readLine().split(" ").map { it.toInt() }
        list[from].add(to)
        list[to].add(from)
    }
    ikstra()
    println("$minhutgan $answer $cnt")
}
private fun ikstra()
{
    val q=LinkedList<Pair<Int,Int>>()
    visit[1]=true
    q.offer(Pair(1,0)) //헛간스 넘버, 거리
    while(q.isNotEmpty())
    {
        val (current,dist )=q.poll()
        if(dist>answer)
        {
            answer=dist
            minhutgan=current
            cnt=1
        }else if(dist==answer) {
            minhutgan= min(minhutgan,current)
            cnt++
        }
        for(i in 0 until list[current].size)
        {
            val next=list[current][i]
            if(!visit[next])
            {
                visit[next]=true
                q.offer(Pair(next,dist+1))
            }
        }
    }
}