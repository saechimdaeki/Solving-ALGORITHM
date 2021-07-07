package LeetCode695

import java.util.*

class Solution {
    val dx= intArrayOf(0,0,1,-1)
    val dy= intArrayOf(1,-1,0,0)
    lateinit var visited:Array<BooleanArray>
    var area=0
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        visited=Array(grid.size){BooleanArray(grid[0].size)}
        grid.indices.forEach { i ->
            grid[i].indices
                .asSequence()
                .filter { grid[i][it]==1 && !visited[i][it] }
                .forEach { area= maxOf(area,bfs(grid,i, it)) }
        }
        return area
    }

    fun bfs(grid:Array<IntArray>,x:Int,y:Int):Int{
        val q=LinkedList<Pair<Int,Int>>()
        q.offer(Pair(x,y))
        visited[x][y]=true
        var cnt=0
        while (q.isNotEmpty()){
            cnt++
            val (nowX,nowY)=q.poll()
            (0 until 4).forEach {
                val (nextX,nextY)= intArrayOf(nowX+dx[it],nowY+dy[it])
                when {
                    nextX>= grid.size || nextX<0 || nextY<0 || nextY>=grid[0].size -> return@forEach
                    else -> when {
                        grid[nextX][nextY] == 1 && !visited[nextX][nextY] -> {
                            visited[nextX][nextY] = true
                            q.offer(Pair(nextX, nextY))
                        }
                    }
                }
            }
        }
        return cnt
    }
}

