package LeetCode287

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        return mutableSetOf<Int>().run {
            nums.indices
                .firstOrNull { !this.add(nums[it]) }
                ?.let { nums[it] }
                ?: nums.size
        }
    }
}

fun main() {
    Solution().apply {
        println(findDuplicate(intArrayOf(1,3,4,2,2))) // 2
        println(findDuplicate(intArrayOf(3,1,3,4,2))) // 3
    }
}