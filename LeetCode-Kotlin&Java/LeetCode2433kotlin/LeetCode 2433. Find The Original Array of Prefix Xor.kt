package 코틀린.LeetCode.LeetCode2433


class Solution {
    fun findArray(pref: IntArray): IntArray {
        val ans = IntArray(pref.size)
        ans[0] = pref[0]
        (1 until pref.size).forEach { i ->
            ans[i] = pref[i] xor pref[i-1]
        }
        return ans
    }
}


fun main() {
    Solution().apply {
        println(findArray(intArrayOf(5, 2, 0, 3, 1)).contentToString()) // [5 ,7, 2, 3, 2]
        println(findArray(intArrayOf(13)).contentToString()) // [13]
    }
}