package LeetCode198

class Solution {
    fun rob(nums: IntArray): Int {
        var (now,pre) = arrayOf(0,0)
        nums.forEach { num ->
            val temp = now
            now = maxOf(num+pre , now)
            pre = temp
        }
        return now
    }
}