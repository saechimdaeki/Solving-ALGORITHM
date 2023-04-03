package boj2623

import java.util.*

lateinit var arr: Array<ArrayList<Int>>
lateinit var inDegree: IntArray
val answerList = mutableListOf<Int>()
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n + 1) { ArrayList() }
    inDegree = IntArray(n + 1)
    repeat(m) {
        val input = readLine()!!.split(" ").map { it.toInt() }

        val temp = input.slice(1 until input.size)
        for (i in 0 until temp.size - 1) {
            arr[temp[i]].add(temp[i + 1])
            inDegree[temp[i + 1]]++
        }
    }
    val q = (1..n).filterTo(LinkedList<Int>()) { inDegree[it] == 0 }
    while (q.isNotEmpty()) {
        val now = q.poll()
        answerList.add(now)
        arr[now].forEach { i ->
            inDegree[i]--
            if (inDegree[i] == 0) {
                q.add(i)
            }
        }
    }
    when (answerList.size) {
        n -> {
            answerList.forEach { println("$it") }
        }
        else -> println(0)
    }
}