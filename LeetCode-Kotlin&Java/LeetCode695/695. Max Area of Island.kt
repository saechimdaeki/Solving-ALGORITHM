package LeetCode695

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var (ans, tmp) = arrayOf(0, 0)
        (grid.indices).forEach { i ->
            (0 until grid[0].size).forEach { j ->
                when {
                    grid[i][j] == 1 -> {
                        tmp = dfs(grid, i, j)
                        ans = maxOf(tmp, ans)
                    }
                }
            }
        }
        return ans
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
        return when {
            i < 0 || grid.size - 1 < i || j < 0 || grid[0].size - 1 < j || grid[i][j] == 0 -> 0
            else -> {
                grid[i][j] = 0

                dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1
            }
        }

    }
}