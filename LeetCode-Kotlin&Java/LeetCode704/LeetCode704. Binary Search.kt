package LeetCode704

/* 704. Binary Search */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val binarySearch = nums.binarySearch(target)
        return if(binarySearch<=-1)
            -1
        else binarySearch
    }
}

fun main() {
    val s  = Solution()

    println(s.search(intArrayOf(-1,0,3,5,9,12),9)) //4

    println(s.search(intArrayOf(-1,0,3,5,9,12),2)) //-1

    println(s.search(intArrayOf(-1,0,3,5,9,12),2)) // -1
}

