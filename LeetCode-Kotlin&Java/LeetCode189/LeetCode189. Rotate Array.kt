package LeetCode189

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var tmpK = k % nums.size
        if (tmpK < 0)
            tmpK += nums.size

        reverse(nums, 0, nums.size - tmpK - 1)
        reverse(nums, nums.size - tmpK, nums.size - 1)
        reverse(nums, 0, nums.size - 1)
    }

    private fun reverse(nums: IntArray, i: Int, j: Int) {
        var (left, right) = arrayOf(i, j)
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp

            left++
            right--
        }
    }
}