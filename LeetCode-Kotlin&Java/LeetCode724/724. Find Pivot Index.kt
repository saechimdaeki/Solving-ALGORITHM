package LeetCode724

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var lSum=0
        (nums.indices).forEach { i ->
            when {
                lSum * 2 == sum-nums[i] -> {
                    return i
                }
                else -> lSum += nums[i]
            }
        }
        return -1
    }
}