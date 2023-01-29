package LeetCode1920

class Solution {
    fun buildArray(nums: IntArray): IntArray {
        return nums.map { nums[it] }.toIntArray()
    }
}