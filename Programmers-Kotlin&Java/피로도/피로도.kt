package 코틀린.programmers.피로도

class Solution {

    val list = mutableListOf<Int>()

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)

        dfs(visited, k, dungeons, 0)

        return list.maxOrNull() ?: 0
    }

    fun dfs(visited: BooleanArray, k: Int, dungeons: Array<IntArray>, count: Int) {
        dungeons.indices.forEach { i ->
            when {
                !visited[i] && k >= dungeons[i][0] -> {
                    visited[i] = true
                    dfs(visited, k - dungeons[i][1], dungeons, count + 1)
                    visited[i] = false
                }
            }
        }
        list.add(count)
    }
}

fun main() {
    Solution().apply {
        println(this.solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(30, 40), intArrayOf(30, 10)))) // 3
    }
}