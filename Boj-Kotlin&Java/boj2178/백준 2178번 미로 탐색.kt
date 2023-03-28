package boj2178

import java.util.*

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val maze = Array(n) { readLine()!!.toCharArray() }
    val dist = Array(n) { IntArray(m) { -1 } }

    val q = LinkedList<Pair<Int, Int>>()
    dist[0][0] = 1
    q.add(Pair(0, 0))
    while (q.isNotEmpty()) {
        val (nowx, nowy) = q.poll()
        for (i in 0 until 4) {
            val nx = nowx + dx[i]
            val ny = nowy + dy[i]
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (maze[nx][ny] == '1' && dist[nx][ny] == -1) {
                dist[nx][ny] = dist[nowx][nowy] + 1
                q.add(Pair(nx, ny))
            }
        }
    }
    println(dist[n - 1][m - 1])
}