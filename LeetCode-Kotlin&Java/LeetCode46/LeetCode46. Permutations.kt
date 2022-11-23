package LeetCode46

import kotlin.collections.ArrayList

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answerList = mutableListOf<MutableList<Int>>()
        return when {
            nums.isEmpty() -> answerList
            else -> {
                permutation(nums, 0, arrayListOf<Int>(), answerList)
                answerList
            }
        }

    }

    private fun permutation(
        nums: IntArray,
        index: Int,
        arrayListOf: ArrayList<Int>,
        answerList: MutableList<MutableList<Int>>
    ) {
        when (arrayListOf.size) {
            nums.size -> {
                answerList.add(arrayListOf)
                return
            }
            else -> (0..arrayListOf.size).forEach { i ->
                ArrayList(arrayListOf).apply {
                    add(i, nums[index])
                    permutation(nums, index + 1, this, answerList)
                }
            }
        }

    }
}