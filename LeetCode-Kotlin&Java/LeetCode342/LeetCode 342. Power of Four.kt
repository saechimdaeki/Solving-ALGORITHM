package 코틀린.LeetCode.LeetCode342

class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        return when {
            n == 0 -> false
            n == 1 -> true
            n % 4 != 0 -> false
            else -> isPowerOfFour(n / 4)
        }
    }
}

fun main() {
    Solution().apply {
        println(isPowerOfFour(16)) // true
        println(isPowerOfFour(5)) // false
        println(isPowerOfFour(1)) // true
    }
}