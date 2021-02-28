package CreateTargetArrayInTheGivenOrder

class Solution {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val ans= arrayListOf<Int>()
        index.indices.forEach { i ->
            when {
                ans.size>=index[i] -> {
                    ans.add(index[i],nums[i])
                }
                else -> ans.add(index[i])
            }
        }
        return ans.toIntArray()
    }
}