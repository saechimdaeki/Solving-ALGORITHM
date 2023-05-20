package 코틀린.디펜스게임

import java.util.PriorityQueue

class Solution {

    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer = 0
        val pq = PriorityQueue<Int>()
        var soldierCount = n

        for (i in enemy.indices) {
            when {
                pq.size < k -> pq.add(enemy[i])
                pq.size == k -> when {
                    pq.peek() < enemy[i] -> {
                        soldierCount -= pq.poll()
                        pq.add(enemy[i])
                    }
                    else -> soldierCount -= enemy[i]
                }
            }
            when {
                soldierCount < 0 -> break
            }
            answer++
        }
        return answer
    }
}

fun main() {
    Solution().apply {
        println(solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1))) // 5
        println(solution(2, 4, intArrayOf(3, 3, 3, 3))) // 4
    }
}