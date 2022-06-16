package LeetCod31608

class Solution {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        (0 .. nums[nums.size-1] step 1).forEach { i ->
            when (val target = search(nums,i)) {
                i -> return target
            }
        }
        return -1
    }
    private fun search(nums: IntArray, target :Int) :Int{
        var (left,right) = arrayOf(0,nums.size-1)
        while (left<=right){
            val mid = left + (right-left)/2
            when {
                target<nums[mid] -> right=mid-1
                target > nums[mid] -> left=mid+1
                else -> right=mid-1
            }
        }
        return nums.size-left
    }
}

fun main() {
    val s = Solution()
    println(s.specialArray(intArrayOf(3,5))) // 2
    println(s.specialArray(intArrayOf(0,0))) // -1
    println(s.specialArray(intArrayOf(0,4,3,0,4))) // 3
}