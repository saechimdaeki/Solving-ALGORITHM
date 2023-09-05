package 코틀린.programmers.k진수에서_소수_개수_구하기

import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        val toString = n.toString(k)

        val s = StringBuilder()
        toString.forEach { c ->
            when (c) {
                '0' -> {
                    val value = s.toString().toLong()
                    when {
                        isPrime(value) -> answer ++
                    }
                    s.setLength(0)
                }
            }
            s.append(c)
        }

        if(isPrime(s.toString().toLong())) answer ++

        return answer
    }

    fun isPrime(n: Long): Boolean {
        if (n == 1L) return false
        if (n == 2L) return true
        if (n % 2 == 0L) return false

        val sqrt = sqrt(n.toDouble()).toLong()
        for (i in 3..sqrt step 2) {
            if (n % i == 0L) return false
        }

        return true
    }
}

fun main() {
    Solution().apply {
        println(solution(437674, 3)) // 3
        println(solution(110011, 10)) //2
    }
}