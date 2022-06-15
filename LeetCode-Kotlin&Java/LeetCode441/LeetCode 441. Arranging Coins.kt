package LeetCode441

class Solution {
    fun arrangeCoins(n: Int): Int {
        var (left,right) = arrayOf(1L,n.toLong())
        var ans = 0L
        while (left<=right){
            val mid = right - (right-left)/2
            val sum = (mid*(mid+1))/2
            when {
                sum<=n -> {
                    ans = mid
                    left=mid+1
                }
                else -> right = mid-1
            }
        }
        return ans.toInt()
    }
}


fun main() {
    val s = Solution()
    println(s.arrangeCoins(5)) // 2

    println(s.arrangeCoins(8)) // 3
}