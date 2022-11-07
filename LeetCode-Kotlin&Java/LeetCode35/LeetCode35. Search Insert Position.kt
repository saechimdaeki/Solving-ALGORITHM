package LeetCode35

/*
Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1


Input: nums = [1,3,5,6], target = 7
Output: 4
 */
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var (left, right) = arrayOf(0, nums.size - 1)
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid
            else if (nums[mid] < target)
                left = mid + 1
            else
                right = mid - 1
        }
        return left
    }
}

fun main() {
    Solution().apply {
        println(searchInsert(intArrayOf(1, 3, 5, 6), 5)) // 2
        println(searchInsert(intArrayOf(1, 3, 5, 6), 2)) // 1
        println(searchInsert(intArrayOf(1, 3, 5, 6), 7)) // 4
    }
}