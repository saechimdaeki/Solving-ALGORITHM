package LeetCode367


/*
    367. Valid Perfect Square
    Do not use any built-in library function such as sqrt.
*/
class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        var (left, right) = arrayOf(1, num / 2)
        while (left <= right) {
            val mid = ((left + right) / 2).toLong()
            when {
                mid * mid == num.toLong() -> return true
                mid * mid < num -> left = (mid + 1).toInt()
                else -> right = (mid - 1).toInt()
            }
        }
        return false
    }
}

fun main() {
    val s = Solution()
    println(s.isPerfectSquare(16)) //true
    println(s.isPerfectSquare(14)) //false
}