package LeetCode1929

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val arr= arrayListOf<Int>()
        arr.addAll(nums.toTypedArray())
        arr.addAll(nums.toTypedArray())
        return arr.toIntArray()
    }
}