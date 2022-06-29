package LeetCode1760

/**
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 */
class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var (left,right) = arrayOf(1,1000000000)
        while (left<right){
            val mid = left+ (right-left)/2
            var temp=0
            nums.forEach { num -> temp += (num - 1) / mid }
            when {
                temp>maxOperations -> left=mid+1
                else -> right = mid
            }
        }
        return left
    }
}

fun main() {
    val s = Solution()
    println(s.minimumSize(intArrayOf(9), 2)) //3

    println(s.minimumSize(intArrayOf(2, 4, 8, 2), 4)) //2

    println(s.minimumSize(intArrayOf(7, 17), 2)) //7
}