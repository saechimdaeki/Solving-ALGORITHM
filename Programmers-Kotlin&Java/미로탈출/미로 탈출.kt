package 코틀린.미로탈출

import java.util.LinkedList

class Solution {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    fun solution(maps: Array<String>): Int {
        var leverX = 0
        var leverY = 0
        var goalX = 0
        var goalY = 0
        var startX = 0
        var startY = 0
        maps.indices.forEach { i ->
            (0 until maps[i].length).forEach { j ->
                when {
                    maps[i][j] == 'S' -> {
                        startX = i
                        startY = j
                    }
                }
                when {
                    maps[i][j] == 'L' -> {
                        leverX = i
                        leverY = j
                    }
                }

                when {
                    maps[i][j] == 'E' -> {
                        goalX = i
                        goalY = j
                    }
                }
            }
        }


        val startToLever = bfs(startX, startY, leverX, leverY, maps)
        val leverToGoal = bfs(leverX, leverY, goalX, goalY, maps)
        return when {
            startToLever == -1 || leverToGoal == -1 -> -1
            else -> startToLever + leverToGoal
        }
    }

    fun bfs(startX: Int, startY: Int, targetX: Int, targetY: Int, maps: Array<String>): Int {
        val q = LinkedList<Pair<Int, Int>>()
        val dist = Array(maps.size) { IntArray(maps[0].length) { -1 } }
        q.offer(Pair(startX, startY))
        dist[startX][startY] = 0

        while (q.isNotEmpty()) {
            val (nowx, nowy) = q.poll()

            when {
                nowx == targetX && nowy == targetY -> {
                    return dist[targetX][targetY]
                }

                else -> (0 until 4).forEach { i ->
                    val (nx, ny) = arrayOf(nowx + dx[i], nowy + dy[i])
                    when {
                        nx < 0 || nx >= maps.size || ny < 0 || ny >= maps[0].length || dist[nx][ny] != -1 -> return@forEach
                        maps[nx][ny] != 'X' -> {
                            q.offer(Pair(nx, ny))
                            dist[nx][ny] = dist[nowx][nowy] + 1
                        }
                    }
                }
            }

        }
        return -1
    }

}


fun main() {
    Solution().apply {
        println(this.solution(arrayOf("SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"))) // 16
        println(this.solution(arrayOf("LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"))) // -1
    }
}