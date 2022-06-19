package LeetCode633

import kotlin.math.sqrt

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var (left,right) = arrayOf(0L, sqrt(c.toFloat()).toLong())
        while (left<=right){
            val sum = left*left + right*right
            when {
                sum==c.toLong() -> return true
                sum>c -> right--
                else -> left++
            }
        }
        return false
    }
}

fun main() {
    val s = Solution()
    println(s.judgeSquareSum(5)) // true
    println(s.judgeSquareSum(3)) // false
}