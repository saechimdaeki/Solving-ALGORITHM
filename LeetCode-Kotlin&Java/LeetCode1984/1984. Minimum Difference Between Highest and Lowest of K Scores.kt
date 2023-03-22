package LeetCode1984

import kotlin.math.min

class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        when (nums.size) {
            1 -> return 0
            else -> {
                nums.sort()
                var (left, right) = arrayOf(0, k - 1)
                var diff: Int
                var answer = Int.MAX_VALUE
                while (right < nums.size) {
                    diff = nums[right] - nums[left]
                    answer = min(diff, answer)
                    left++
                    right++
                }
                return answer
            }
        }
    }
}