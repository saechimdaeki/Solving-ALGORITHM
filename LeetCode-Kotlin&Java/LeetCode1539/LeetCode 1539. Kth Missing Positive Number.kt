package LeetCode1539

class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var (left,right) = arrayOf(0, arr.size-1)
        while (left<=right){
            val mid = left+(right-left)/2
            when {
                arr[mid]- mid - 1 < k -> left=mid+1
                else -> right=mid-1
            }
        }
        return left+k
    }
}

fun main() {
    val s = Solution()
    println(s.findKthPositive(intArrayOf(2,3,4,7,11),5)) // 9
    println(s.findKthPositive(intArrayOf(1,2,3,4), 2)) //6

}