package 코틀린.혼자놀기의달인

class Solution {

    lateinit var visited: BooleanArray
    var level = 0
    fun solution(cards: IntArray): Int {
        visited = BooleanArray(cards.size + 1)
        val list = mutableListOf<Int>()
        cards.indices.forEach { i ->
            when {
                !visited[i+1] -> {
                    level = 1
                    visited[i + 1] = true
                    dfs(cards[i], cards)
                    list.add(level)
                }
            }
        }
        return when {
            list.size < 2 -> 0
            else -> {
                list.sortDescending()
                list[0] * list[1]
            }
        }
    }

    fun dfs(x: Int, cards: IntArray) {
        if (visited[x]) return
        visited[x] = true
        level++
        dfs(cards[x - 1], cards)
    }
}

fun main() {
    Solution().apply {
        println(solution(intArrayOf(8, 6, 3, 7, 2, 5, 1, 4))) // 12
    }
}