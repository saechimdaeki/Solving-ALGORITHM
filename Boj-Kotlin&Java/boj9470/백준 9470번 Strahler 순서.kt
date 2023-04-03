package boj9470

import java.util.LinkedList

lateinit var arr: Array<MutableList<Int>>
lateinit var indegree: IntArray
lateinit var maxCnt : IntArray
lateinit var order : IntArray

fun main() {
    val t = readLine()!!.toInt()
    val bw = System.out.bufferedWriter()
    repeat(t) {
        val (k,m,p) = readLine()!!.split(" ").map { it.toInt() }
        arr = Array(m+1) { mutableListOf() }
        indegree = IntArray(m+1)
        maxCnt = IntArray(m+1)
        order = IntArray(m+1)
        repeat(p) {
            val (a,b) = readLine()!!.split(" ").map { it.toInt() }
            arr[a].add(b)
            indegree[b]++
        }

        val q = LinkedList<Int>()
        var answer = 0
        for (i in 1..m) {
            if (indegree[i] == 0) {
                q.add(i)
                order[i] = 1
                maxCnt[i] = 1
            }
        }

        while (q.isNotEmpty()) {
            val now = q.poll()
            if(maxCnt[now] >=2)
                order[now]++

            answer = maxOf(answer, order[now])

            for (next in arr[now]) {
                indegree[next]--
                if (indegree[next] == 0) {
                    q.add(next)
                }
                if(order[next] == order [now])
                    maxCnt[next]++
                else if (order[next] < order[now]) {
                    order[next] = order[now]
                    maxCnt[next] = 1
                }
            }
        }

        bw.write("$k $answer\n")
    }

    bw.flush()
}