package boj1516

import java.util.LinkedList

lateinit var arr: Array<MutableList<Int>>
lateinit var indegree: IntArray
lateinit var time: IntArray
lateinit var list:IntArray
fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n+1) { mutableListOf() }
    indegree = IntArray(n+1)
    time = IntArray(n+1)
    list = IntArray(n+1)
    repeat(n) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        time[it+1] = input[0]
        for(i in 1 until input.size-1) {
            if(input[i] == -1) break
            arr[input[i]].add(it+1)
            indegree[it+1]++
        }
    }

    val q= LinkedList<Int>()
    (1..n).forEach { if(indegree[it] == 0) q.add(it) }

    while(q.isNotEmpty()) {
        val now = q.poll()
        for(next in arr[now]) {
            indegree[next]--
            list[next] = maxOf(list[next], list[now] + time[now])
            if(indegree[next] == 0) q.add(next)
        }
    }

    (1..n).forEach { println(list[it] + time[it]) }
}