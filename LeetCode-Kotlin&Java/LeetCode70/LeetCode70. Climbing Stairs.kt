package LeetCode70

class Solution {
    private val map = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        return when (n) {
            1, 2 -> n
            else -> map[n] ?: kotlin.run {
                val (n1, n2) = arrayOf(climbStairs(n - 1), climbStairs(n - 2))
                map[n - 1] = n1
                map[n - 2] = n2
                n1 + n2
            }
        }
    }
}