package LeetCode1283

class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var (left, right) = arrayOf(1, 1000000)
        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                check(nums, mid) > threshold -> left = mid + 1
                else -> right = mid
            }
        }
        return left
    }

    private fun check(nums: IntArray, target: Int) = run {
        var cnt = 0
        nums.indices.forEach { i ->
            cnt += nums[i] / target
            when {
                nums[i] % target > 0 -> cnt++
            }
        }
        cnt
    }
}

fun main() {
    Solution().apply {
        println(smallestDivisor(intArrayOf(1, 2, 5, 9), 6)) // 5
        println(smallestDivisor(intArrayOf(44, 22, 33, 11, 1), 5)) //44
    }
}