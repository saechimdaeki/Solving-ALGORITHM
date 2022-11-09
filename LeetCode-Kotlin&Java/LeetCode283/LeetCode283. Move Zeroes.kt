package LeetCode283

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        if(nums.isEmpty())
            return
        var idx= 0
        nums.indices.forEach { i ->
            when {
                nums[i] != 0 -> {
                    val temp = nums[idx]
                    nums[idx++] = nums[i]
                    nums[i] = temp
                }
            }
        }
    }
}

