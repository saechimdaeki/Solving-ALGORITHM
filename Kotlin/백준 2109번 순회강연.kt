package boj14681kot

import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val arr=ArrayList<Pair<Int,Int>>()
    for(i in 0 until n)
    {
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(a,b))
    }
    arr.sortBy { -it.second }
    var count=0
    var answer=0
    val q:PriorityQueue<Int> = PriorityQueue()
    for(i in 10000 downTo 1 )
    {
        while(count<n && arr[count].second==i)
        {
            q.offer(-arr[count].first)
            count++
        }
        if(q.isNotEmpty())
        {
            answer+= ( -q.poll())
        }
    }
    println(answer)
}