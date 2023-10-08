package 코틀린.boj.강의실_배정

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val lecture = mutableListOf<Pair<Int,Int>>()
    repeat(n) {
        val (s,t) = br.readLine().split(" ").map { it.toInt() }
        lecture.add(Pair(first= s, second = t))
    }

    lecture.sortBy { it.first }

    val pq = PriorityQueue<Int>()
    var ans = 0
    for (pair in lecture) {
        while (pq.isNotEmpty() && pq.peek() <= pair.first) {
            pq.poll()
        }
        pq.add(pair.second)
        ans = maxOf(ans, pq.size)
    }
    println(ans)
}