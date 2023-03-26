package LeetCode2367

class Solution {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val set = nums.toSet()
        var answer = 0

        for(i in nums.indices) {
            if (set.contains(nums[i] + diff) && set.contains(nums[i] + 2*diff))
                answer++
        }


        return answer
    }
}