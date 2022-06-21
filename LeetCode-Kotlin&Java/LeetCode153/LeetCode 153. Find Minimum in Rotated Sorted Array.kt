package LeetCode153

class Solution {
    fun findMin(nums: IntArray): Int {
        var (left,right) = arrayOf(0,nums.size-1)
        while (left<=right){
            val mid = left + (right-left)/2
            when {
                mid>0 && nums[mid] < nums[mid-1] -> return nums[mid]
                nums[mid]>=nums[left] -> when {
                    nums[mid]>nums[right] -> left = mid+1
                    else -> right = mid-1
                }
                else -> right= mid-1
            }
        }
        return nums[left]
    }
}

fun main() {
    val s = Solution()
    println(s.findMin(intArrayOf(3,4,5,1,2))) // 1
    println(s.findMin(intArrayOf(4,5,6,7,0,1,2))) // 0
    println(s.findMin(intArrayOf(11,13,15,17))) // 11
}