package LeetCode1920

class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val arr=nums.copyOf()
        arr.indices.forEach { i ->
            arr[i]=nums[nums[i]]
        }
        return arr
    }
}