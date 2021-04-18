package LeetCode959

class Solution {
    lateinit var visited:Array<Array<BooleanArray>>
    fun regionsBySlashes(grid: Array<String>): Int {
        val (y,x)= intArrayOf(grid.size,grid[0].length)
        visited=Array(y){Array(x){ BooleanArray(4) }}
        var cnt=0
        for(i in 0 until y){
            for(j in 0 until x){
                for(k in 0 until 4){
                    if(!visited[i][j][k]){
                        dfs(i,j,k,grid)
                        cnt++
                    }
                }
            }
        }
        return cnt
    }
    fun dfs(y:Int,x:Int,dir:Int,grid:Array<String>){
        if(y<0 || x<0 ||y>=grid.size||x>=grid.size) return
        if(visited[y][x][dir]) return
        visited[y][x][dir]=true
        when (dir) {
            0 -> {
                dfs(y-1,x,2,grid)
            }
            1 -> {
                dfs(y,x+1,3,grid)
            }
            2 -> {
                dfs(y+1,x,0,grid)
            }
            3 -> {
                dfs(y,x-1,1,grid)
            }
        }
        if(grid[y][x]!='/'){
            dfs(y,x,(dir xor 1) ,grid)
        }
        if(grid[y][x]!='\\'){
            dfs(y,x,(dir xor 3), grid)
        }
    }
}