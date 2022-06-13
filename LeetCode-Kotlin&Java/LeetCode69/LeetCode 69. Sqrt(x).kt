package LeetCode69

/* 69. Sqrt(x) */
class Solution {
    fun mySqrt(x: Int): Int {
        if(x==0) return 0
        var (left,right) = arrayOf(1, x/2+1)
        while (left<=right){
            val mid = left + (right-left)/2
            if (mid == x/mid) return mid
            else if (mid< x/mid) left = mid+1
            else right = mid-1
        }
        return right
    }
}

fun main() {
    val s= Solution()
    println(s.mySqrt(4)) //2
    println(s.mySqrt(8)) //2
}