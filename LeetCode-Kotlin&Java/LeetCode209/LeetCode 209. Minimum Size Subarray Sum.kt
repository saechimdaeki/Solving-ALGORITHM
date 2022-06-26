package LeetCode209

/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target. If there is no such subarray,
return 0 instead.
 */
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var (s, e, sum) = arrayOf(0, 0, 0)
        while (e < nums.size) {
            sum += nums[e]
            e++
            while (sum >= target) {
                sum -= nums[s]
                min = minOf(min, e - s)
                s++
            }
        }
        return when (min) {
            Int.MAX_VALUE -> 0
            else -> min
        }
    }
}

fun main() {
    val s = Solution()
    println(s.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) //2

    println(s.minSubArrayLen(4, intArrayOf(1, 4, 4))) //1

    println(s.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) //0
}