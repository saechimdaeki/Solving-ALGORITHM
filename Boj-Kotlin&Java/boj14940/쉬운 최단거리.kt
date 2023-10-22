package 코틀린.boj.boj14940

import java.util.*

lateinit var arr: Array<IntArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var sx = -1
var sy = -1
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until n) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 2) {
                sx = i
                sy = j
            } else if (arr[i][j] != 0)
                arr[i][j] = -1
        }
    }

    val q = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(sx, sy))
    arr[sx][sy] = 0
    while (q.isNotEmpty()) {
        val (nowx, nowy) = q.poll()
        for (i in 0 until 4) {
            val (nx, ny) = arrayOf(nowx + dx[i], nowy + dy[i])
            if (nx < 0 || nx == n || ny < 0 || ny >= m || arr[nx][ny] != -1) continue
            arr[nx][ny] = arr[nowx][nowy] + 1
            q.offer(Pair(nx, ny))
        }
    }

    for (ints in arr) {
        for (int in ints)
            bw.write("$int ")
        bw.write("\n")
    }
    bw.flush()
}