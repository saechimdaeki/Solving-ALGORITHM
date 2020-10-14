package 백준

import java.util.*
import kotlin.system.exitProcess

fun main() {
    val n= readLine()!!.toInt()
    val pq=PriorityQueue<Int>()
    repeat(n){
        pq.offer(readLine()!!.toInt())
    }
    var sum=0
    if(pq.size==1){
        print(0)
        exitProcess(0)
    }
    while (pq.isNotEmpty()){
        val a=pq.poll()
        val b=pq.poll()
        sum+=(a+b)
        if(pq.isEmpty()) break
        pq.offer(a+b)
    }
    print(sum)
}