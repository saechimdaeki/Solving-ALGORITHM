package LeetCode120

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = Array(triangle.size+1){IntArray(triangle.size+1){0}}
        (triangle.size-1 downTo 0).forEach { i ->
            (0 ..i).forEach { j ->
                dp[i][j]= triangle[i][j] + minOf(dp[i+1][j], dp[i+1][j+1])
            }
        }
        return dp[0][0]
    }
}

