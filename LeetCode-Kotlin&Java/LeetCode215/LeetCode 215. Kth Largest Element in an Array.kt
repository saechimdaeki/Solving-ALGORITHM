package 코틀린.LeetCode.LeetCode215

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k-1]
    }
}