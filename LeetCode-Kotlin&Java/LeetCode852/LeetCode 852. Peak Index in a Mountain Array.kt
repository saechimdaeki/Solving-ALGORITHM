package LeetCode852

/* 852. Peak Index in a Mountain Array */

class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var (left,right) = arrayOf(0,arr.size-1)
        while (left<right){
            val mid = left+(right-left)/2
            when {
                arr[mid]> arr[mid+1] -> right=mid
                else -> left=mid+1
            }
        }
        return left
    }
}

fun main() {
    val s = Solution()

    println(s.peakIndexInMountainArray(intArrayOf(0,1,0))) // 1

    println(s.peakIndexInMountainArray(intArrayOf(0,2,1,0))) // 1

    println(s.peakIndexInMountainArray(intArrayOf(0,10,5,2))) // 1
}