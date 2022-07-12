package LeetCode1482

/**
 * You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        return when {
            m*k>bloomDay.size -> -1
            else -> {
                var (left, right) = arrayOf(1, 1000000000)
                while (left <= right) {
                    val mid = left + (right - left) / 2
                    when {
                        check(bloomDay, k, mid, m) -> right = mid - 1
                        else -> left = mid + 1
                    }
                }
                right + 1
            }
        }
    }
    private fun check(bloomDay: IntArray, k: Int, mid:Int, m:Int) = run {
        var (tmp,start)= arrayOf(0,0)
        bloomDay.indices.forEach { i ->
            when {
                bloomDay[i] > mid -> start=i+1
                i-start+1==k -> {
                    tmp++
                    start=i+1
                }
            }
        }
        tmp>=m
    }
}

fun main() {
    Solution().apply {
        println(minDays(intArrayOf(1,10,3,10,2),3,1)) // 3
        println(minDays(intArrayOf(1,10,3,10,2),3,2)) // -1
        println(minDays(intArrayOf(7,7,7,7,12,7,7),2,3)) //12
    }
}