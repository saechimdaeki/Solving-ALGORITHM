package LeetCode217

/* 217. Contains Duplicate */
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        nums.forEach { num ->
            when {
                set.contains(num) -> return true
                else -> set.add(num)
            }
        }
        return false
    }
}