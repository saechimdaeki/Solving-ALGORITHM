package 코틀린.LeetCode.LeetCode1985

import java.math.BigInteger

class Solution {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val list = mutableListOf<BigInteger>()

        for (num in nums) {
            list.add(num.toBigInteger())
        }
        val sortedDescending = list.sortedDescending()
        return sortedDescending[k-1].toString()
    }
}