package 코틀린.무인도여행

import java.util.LinkedList

class Solution {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    lateinit var visited: Array<BooleanArray>
    val answer = arrayListOf<Int>()
    fun solution(maps: Array<String>): IntArray {

        visited = Array(maps.size) { BooleanArray(maps[0].length) }

        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j, maps))
                }
            }
        }


        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }

    fun bfs(x: Int, y: Int, maps: Array<String>): Int {
        var ans = 0
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(x, y))
        visited[x][y] = true
        while (q.isNotEmpty()) {
            val (nowx, nowy) = q.poll()
            ans += maps[nowx][nowy] - '0'
            for (i in 0 until 4) {
                val (nx, ny) = arrayOf(nowx + dx[i], nowy + dy[i])

                if (nx<0 || nx >= maps.size || ny <0 || ny >= maps[0].length || visited[nx][ny] || maps[nx][ny] == 'X') continue
                visited[nx][ny] = true
                q.offer(Pair(nx,ny))
            }
        }
        return ans
    }
}

fun main() {
    Solution().apply {
        val solution1 = this.solution(arrayOf("X591X", "X1X5X", "X231X", "1XXX1"))

        for (i in solution1) {
            print("$i ")
        }
        println()

        val solution2 = this.solution(arrayOf("XXX", "XXX", "XXX"))
        for (i in solution2) {
            print("$i ")
        }
        println()
    }
}