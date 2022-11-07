package LeetCode704

/*
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var (left, right) = arrayOf(0, nums.size - 1)
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid
            else if (nums[mid] < target)
                left = mid + 1
            else
                right = mid - 1
        }
        return -1
    }
}

fun main() {
    Solution().apply {
        println(search(intArrayOf(-1,0,3,5,9,12),9)) // 4
        println(search(intArrayOf(-1,0,3,5,9,12),2)) // -1
        println(search(intArrayOf(5), 5)) // 1
    }
}