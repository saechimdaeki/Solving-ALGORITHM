package LeetCode1913

class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        nums.sortDescending()
        return (nums[0]*nums[1]) - (nums[nums.size-1] *nums[nums.size-2])
    }
}