package LeetCode980

class Solution {
    var ans=0
    lateinit var visited:Array<BooleanArray>
    fun uniquePathsIII(grid: Array<IntArray>): Int { //ㅇㅠ니크패스==1
        visited=Array(grid.size){ BooleanArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    for(k in grid.indices)
                        visited[k].fill(false)
                    ans+=dfs(i, j, grid)
                }
            }
        }
        return ans
    }
    fun dfs(y:Int,x:Int,grid:Array<IntArray>):Int{
        var cnt=0
        if(grid[y][x]==-1)
            return cnt
        if (grid[y][x] == 2) { //기저사례
            for(i in grid.indices){
                for(j in grid[i].indices){
                    if(grid[i][j]==0 && !visited[i][j]) return 0
                }
            }
            return 1
        }
        if (!visited[y][x]) { //backtracking
            visited[y][x] = true
            if (y - 1 >= 0) cnt += dfs(y - 1, x, grid)
            if (y + 1 < grid.size) cnt += dfs(y + 1, x, grid)
            if (x - 1 >= 0) cnt += dfs(y, x - 1, grid)
            if (x + 1 < grid[0].size) cnt += dfs(y, x + 1, grid)
            visited[y][x] = false
        }
        return cnt
    }
}

fun main() {
    val s=Solution()
    println("${s.uniquePathsIII(arrayOf(intArrayOf(1,0,0,0), intArrayOf(0,0,0,0), intArrayOf(0,0,2,-1)))}")

}