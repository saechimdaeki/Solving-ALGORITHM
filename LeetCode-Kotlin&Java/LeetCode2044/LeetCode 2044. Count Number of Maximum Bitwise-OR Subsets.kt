package 코틀린.LeetCode.LeetCode2044


class Solution {
    var answer = 0
    fun countMaxOrSubsets(nums: IntArray): Int {
        var max = nums[0]
        for(i in 1 until nums.size)
            max = max or nums[i]
        dfs(nums,0, mutableListOf(),max)
        return answer
    }

    fun dfs(nums: IntArray, idx: Int, now: MutableList<Int>, max : Int) {
        if (now.isNotEmpty() && now[now.size-1] == max) {
            answer++
        }

        for(i in idx until nums.size) {
            if (now.isNotEmpty())
                now.add(nums[i] or now[now.size-1])
            else
                now.add(nums[i])
            dfs(nums, i+1 , now, max)
            now.removeAt(now.size-1)
        }
    }
}

fun main() {
    Solution().apply {
        println(countMaxOrSubsets(intArrayOf(3, 1))) // 2
        println(countMaxOrSubsets(intArrayOf(2, 2, 2))) // 7
        println(countMaxOrSubsets(intArrayOf(3, 2, 1, 5))) // 6
    }
}