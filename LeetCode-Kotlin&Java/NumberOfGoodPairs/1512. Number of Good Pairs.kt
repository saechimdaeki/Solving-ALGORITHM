package NumberOfGoodPairs

class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        var idx=0
        nums.indices.forEach { i ->
            repeat((i+1 until nums.size)
                    .asSequence()
                    .filter { nums[i]==nums[it] }.count()) { idx++ }
        }
        return idx
    }
}
