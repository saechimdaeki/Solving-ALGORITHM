package 코틀린.귤고르기


class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        var kTemp = k
        tangerine.toList().groupBy { it }.map { it.value.size }
            .sortedDescending().forEach {
            when {
                kTemp > 0 -> {
                    kTemp -= it
                    answer++
                }
                else -> return answer
            }
        }
        return answer
    }
}

fun main() {


    Solution().apply {
        println(solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))) // 3
        println(solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))) // 2
        println(solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3))) // 1
    }
}