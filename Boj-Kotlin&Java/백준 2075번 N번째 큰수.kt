package 백준

import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val pq=PriorityQueue<Int>()
    repeat((0 until n).count()) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        temp.forEach { j ->
            pq.offer(j)
            if (pq.size > n) pq.remove()
        }
    }
    println("${pq.peek()}")
}