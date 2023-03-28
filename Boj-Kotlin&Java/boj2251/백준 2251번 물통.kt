package boj2251

import java.util.*

val answerList = mutableListOf<Int>()
fun main() {
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val visited = Array(201) { Array(201) { IntArray(201) } }
    val q = LinkedList<Triple<Int, Int, Int>>()

    q.add(Triple(0, 0, arr[2]))

    while (q.isNotEmpty()) {
        val (x, y, z) = q.poll()
        if (visited[x][y][z] == 1) continue
        visited[x][y][z] = 1

        if (x == 0) answerList.add(z)

        if (x + y > arr[1]) {
            q.add(Triple(x - (arr[1] - y), arr[1], z))
        } else
            q.add(Triple(0, x + y, z))

        if (x + z > arr[2]) {
            q.add(Triple(x - (arr[2] - z), y, arr[2]))
        } else
            q.add(Triple(0, y, x + z))

        if (y + x > arr[0]) {
            q.add(Triple(arr[0], y - (arr[0] - x), z))
        } else
            q.add(Triple(y + x, 0, z))

        if (y + z > arr[2]) {
            q.add(Triple(x, y - (arr[2] - z), arr[2]))
        } else
            q.add(Triple(x, 0, y + z))

        if (z + x > arr[0]) {
            q.add(Triple(arr[0], y, z - (arr[0] - x)))
        } else
            q.add(Triple(z + x, y, 0))

        if (z + y > arr[1])
            q.add(Triple(x, arr[1], z - (arr[1] - y)))
        else
            q.add(Triple(x, z + y, 0))
    }
    answerList.sort()
    answerList.forEach { print("$it ") }
}