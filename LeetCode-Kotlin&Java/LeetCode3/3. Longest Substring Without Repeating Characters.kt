package LeetCode3

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var (answer,idx) = arrayOf(0,0)
        val map= mutableMapOf<Char,Int>()
        s.indices.forEachIndexed { _, c ->
            map[s[c]]?.let {
                idx = max(idx, it + 1)
            }
            map[s[c]] = c
            answer = max(answer, c - idx + 1)
        }

        return answer
    }
}

fun main() {
    Solution().also {
        println(it.lengthOfLongestSubstring("abcabcbb")) //3
        println(it.lengthOfLongestSubstring("bbbbb")) //1
        println(it.lengthOfLongestSubstring("pwwkew")) //3
    }
}