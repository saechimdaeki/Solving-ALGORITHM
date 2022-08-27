package LeetCode1558

class Solution {
    fun minOperations(nums: IntArray): Int {
        var ans =0
        for (i in 0 until 32) {
            var zero = false
            nums.indices.forEach {
                ans+= nums[it]%2
                nums[it]/=2
                zero = zero or (nums[it] > 0)
            }
            if (zero)
                ans++
            else break
        }

        return ans
    }
}

fun main() {
    Solution().apply {
        println(minOperations(intArrayOf(1,5))) // 5
        println(minOperations(intArrayOf(2,2))) // 3
        println(minOperations(intArrayOf(4,2,5))) // 6

    }
}