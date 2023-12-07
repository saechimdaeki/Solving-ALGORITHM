package 코틀린.LeetCode.LeetCode1903

class Solution {
    fun largestOddNumber(num: String): String {
        return (num.length - 1 downTo 0)
            .firstOrNull { num[it].code % 2 == 1 }
            ?.let { num.substring(0, it + 1) }
            ?: ""

    }
}