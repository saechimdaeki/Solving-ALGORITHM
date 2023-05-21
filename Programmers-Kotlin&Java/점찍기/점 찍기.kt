package 코틀린.점찍기

import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer = 0L
        for (x in 0..d step k) {
            val y = sqrt(d.toDouble().pow(2.0) - x.toDouble().pow(2.0)).toInt()
            // k의 배수 + 0 (카운팅)
            answer += (y / k) +1
        }

        return answer
    }
}

fun main() {
    Solution().apply {
        println(solution(2, 4)) // 6
        println(solution(1, 5)) // 26
    }
}