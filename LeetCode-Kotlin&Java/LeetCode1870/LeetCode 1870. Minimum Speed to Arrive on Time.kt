package LeetCode1870

import kotlin.math.ceil

class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        var (left, right) = arrayOf(1, 10000000)
        return when {
            hour<=dist.size-1 -> -1
            else -> {
                while (left <= right) {
                    val mid = left + (right - left) / 2
                    when {
                        !check(dist, mid, hour) -> left = mid + 1
                        else -> right = mid - 1
                    }
                }
                right + 1
            }
        }
    }

}

private fun Solution.check(dist: IntArray, mid: Int, hour: Double) = run {
    var temp = 0.0
    (0 until dist.size - 1).forEachIndexed { _, i -> temp += ceil((dist[i].toDouble() / mid)) }
    temp += (dist[dist.size - 1].toDouble() / mid)

    temp <= hour
}

fun main() {
    Solution().apply {
        println(minSpeedOnTime(intArrayOf(1, 3, 2), 6.0)) //1

        println(minSpeedOnTime(intArrayOf(1, 3, 2), 2.7)) // 3
    }
}