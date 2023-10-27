package 코틀린.LeetCode.LeetCode5

class Solution {
    fun longestPalindrome(s: String): String {
        var (start, end) = 0 to 0
        s.indices.forEach { i ->
            val char = s[i]
            var (left, right) = i to i
            while (left >= 0 && s[left] == char) left--
            while (right < s.length && s[right] == char) right++
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
            }
            left ++
            when {
                end - start < right - left -> {
                    start = left
                    end = right
                }
            }
        }
        return s.substring(start, end)
    }
}


fun main() {
    Solution().apply {
        println(longestPalindrome("babad")) // "bab"
        println(longestPalindrome("cbbd")) // "bb"
    }
}