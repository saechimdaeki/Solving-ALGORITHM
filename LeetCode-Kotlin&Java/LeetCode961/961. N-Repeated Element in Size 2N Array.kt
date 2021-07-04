package LeetCode961

class Solution {
    fun repeatedNTimes(nums: IntArray): Int {
        val length=nums.size/2
        val map= mutableMapOf<Int,Int>()
        nums.indices.forEach { i ->
            when {
                map.keys.contains(nums[i]) -> {
                    map[nums[i]] = map[nums[i]]!!+1
                    return nums[i]
                }
                else -> map[nums[i]] = 1
            }
        }
        return 0
    }
}