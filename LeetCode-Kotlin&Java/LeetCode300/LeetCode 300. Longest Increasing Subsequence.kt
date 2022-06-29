package LeetCode300

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val memo = Array(nums.size){0}
        var temp=0
        nums.indices.forEach { idx ->
            var (left,right) = arrayOf(0,temp)
            while (left!=right){
                val mid = left+(right-left)/2
                when {
                    memo[mid]<nums[idx] -> left=mid+1
                    else -> right=mid
                }
            }
            memo[left]=nums[idx]
            when (left) {
                temp -> temp++
            }
        }
        return temp
    }
}


fun main() {
    val s = Solution()
    println(s.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))) //4
    println(s.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))) //4
    println(s.lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))) //1
}