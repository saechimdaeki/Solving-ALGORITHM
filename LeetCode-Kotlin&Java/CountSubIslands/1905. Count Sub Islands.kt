class Solution {
    var fill = false
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var answer=0
        grid1.indices.forEach { i ->
            (0 until grid1[0].size).forEach { j ->
                when {
                    grid2[i][j]==1 -> {
                        fill=true
                        dfs(grid1,grid2,i,j,grid1.size,grid1[0].size)
                        when {
                            fill -> answer++
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun dfs(grid1: Array<IntArray>, grid2: Array<IntArray>, i : Int, j : Int, row:Int, col:Int){
        when {
            i<0 || i>=row || j<0|| j>=col || grid2[i][j]==0 -> return
            else -> when {
                grid1[i][j] == 0 -> {
                    fill = false
                    return
                }
                else -> {
                    grid2[i][j] = 0
                    dfs(grid1, grid2, i + 1, j, row, col)
                    dfs(grid1, grid2, i - 1, j, row, col)
                    dfs(grid1, grid2, i, j + 1, row, col)
                    dfs(grid1, grid2, i, j - 1, row, col)
                }
            }
        }
    }

}