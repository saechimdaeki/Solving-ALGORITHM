package boj1697

import java.util.LinkedList

fun main() {
    val (n,x) = readLine()!!.split(" ").map { it.toInt() }
    val dist = IntArray(100001){-1}
    val q = LinkedList<Int>()
    q.add(n)
    dist[n] = 0

    while(q.isNotEmpty()) {
        val now = q.poll()
        if (now == x) {
            println(dist[now])
            break
        }
        for(i in 0 until 3) {
            val nx = when(i) {
                0 -> now -1
                1 -> now +1
                else -> now *2
            }
            if(nx < 0 || nx > 100000) continue
            if(dist[nx] == -1) {
                dist[nx] = dist[now] + 1
                q.add(nx)
            }
        }
    }
}