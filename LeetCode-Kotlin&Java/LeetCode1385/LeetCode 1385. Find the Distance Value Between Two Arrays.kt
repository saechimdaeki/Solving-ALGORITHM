package LeetCode1385

import java.util.TreeSet

/* 1385. Find the Distance Value Between Two Arrays */
class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        val set= TreeSet<Int>(arr2.toList())
        var diff = 0
        arr1.forEachIndexed { _, it ->
            val (left, right) = arrayOf(it - d, it + d)
            val subSet = set.subSet(left, right + 1)
            when {
                subSet.isEmpty() -> diff++
            }
        }
        return diff
    }
}

fun main() {
    val s = Solution()
    println(s.findTheDistanceValue(intArrayOf(4,5,8), intArrayOf(10,9,1,8),2)) // 2
    println(s.findTheDistanceValue(intArrayOf(1,4,2,3), intArrayOf(-4,-3,6,10,20,30),3)) // 2
    println(s.findTheDistanceValue(intArrayOf(2,1,100,3), intArrayOf(-5,-2,10,-3,7),6)) // 1
}