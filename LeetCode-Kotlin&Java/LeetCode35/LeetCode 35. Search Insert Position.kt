package LeetCode35

/* 35. Search Insert Position */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var (left,right) = arrayOf(0,nums.size-1)
        while (left<=right){
            val mid = (left+right)/2
            when {
                nums[mid]>target -> right=mid-1
                nums[mid]==target -> return mid
                else -> left=mid+1
            }
        }
        return left
    }
}

fun main() {
    val s = Solution()
    println(s.searchInsert(intArrayOf(1,3,5,6),5)) //2
    println(s.searchInsert(intArrayOf(1,3,5,6),2)) //1
    println(s.searchInsert(intArrayOf(1,3,5,6),7)) //4
}