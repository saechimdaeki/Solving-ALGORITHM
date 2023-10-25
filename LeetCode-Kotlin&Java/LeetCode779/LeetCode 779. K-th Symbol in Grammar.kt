package 코틀린.LeetCode.LeetCode779

class Solution {
    fun kthGrammar(n: Int, k: Int): Int {
        return when (n) {
            1 -> 0
            else -> {
                val prev = kthGrammar(n - 1, (k + 1) / 2)
                when {
                    k % 2 == 0 -> if (prev == 1) 0 else 1
                    else -> prev
                }
            }
        }
    }
}

fun main() {
    Solution().apply {
        println(kthGrammar(1, 1)) // 0
        println(kthGrammar(2, 1)) // 0
        println(kthGrammar(2, 2)) // 1
    }
}