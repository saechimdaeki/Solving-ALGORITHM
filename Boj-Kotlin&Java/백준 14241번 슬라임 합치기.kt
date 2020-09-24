package 백준

import java.util.*

fun main() {
    val n= readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }
    val q=PriorityQueue(arr)
    var sum=0
    while (q.isNotEmpty()){
        val a=q.poll()
        if(q.size==0) break
        val b=q.poll()
        q.offer(a+b)
        sum+=(a*b)
    }
    println(sum)
}