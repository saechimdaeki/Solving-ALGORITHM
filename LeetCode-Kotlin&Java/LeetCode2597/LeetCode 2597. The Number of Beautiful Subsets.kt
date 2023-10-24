package 코틀린.LeetCode.LeetCode2597

class Solution {
    lateinit var answer: MutableList<MutableList<Int>>
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        nums.sort()
        answer = mutableListOf()
        dfs(nums, 0, mutableListOf(), k)
        return answer.size
    }

    fun dfs(nums: IntArray, idx: Int, now: MutableList<Int>, k: Int) {
        if (idx == nums.size) {
            if (now.isNotEmpty())
                answer.add(now)
            return
        }

        if (!now.contains(nums[idx] - k)) {
            now.add(nums[idx])
            dfs(nums, idx + 1, now, k)
            now.removeAt(now.size - 1)
        }
        dfs(nums, idx + 1, now, k)
    }
}

fun main() {
    Solution().apply {
        println(beautifulSubsets(intArrayOf(2, 4, 6), 2)) // 4
        println(beautifulSubsets(intArrayOf(1), 1))// 1
    }
}