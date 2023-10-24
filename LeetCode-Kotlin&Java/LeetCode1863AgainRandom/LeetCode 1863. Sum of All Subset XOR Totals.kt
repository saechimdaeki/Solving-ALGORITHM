package 코틀린.LeetCode.LeetCode1863

class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        return dfs(nums,0,0)
    }
    fun dfs(nums: IntArray, idx : Int, now:Int): Int {
        if(idx == nums.size) return now
        val withXor = dfs(nums, idx + 1, now xor nums[idx])
        val withoutXor = dfs(nums, idx + 1, now)
        return withXor + withoutXor
    }
}


fun main() {
    Solution().apply {
        println(subsetXORSum(intArrayOf(1, 3))) // 6
        println(subsetXORSum(intArrayOf(5, 1, 6))) // 28
    }
}