package LeetCode994

import java.util.LinkedList

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val dx = arrayOf(1,-1,0,0)
        val dy = arrayOf(0,0,1,-1)
        var (min, cnt) = arrayOf(-1,0)
        val q = LinkedList<Pair<Int,Int>>()
        grid.indices.forEach { i ->
            (0 until grid[0].size).forEach { j ->
                when {
                    grid[i][j] == 2 -> q.offer(Pair(i,j))
                    grid[i][j] == 1 -> cnt++
                }
            }
        }
        when {
            cnt ==0 -> return 0
            q.size ==0 -> return -1
        }
        while (q.isNotEmpty()) {
            min++
            val size = q.size
            (0 until size).forEach { i ->
                val poll = q.poll()
                val (nowX,nowY) = arrayOf(poll.first, poll.second)
                (0 until 4).forEach { j ->
                    val (nx,ny) = arrayOf(nowX+dx[j],nowY+dy[j])
                    when {
                        nx>= grid.size || nx<0 || ny>=grid[0].size || ny<0 -> return@forEach
                        else -> when {
                            grid[nx][ny] == 1 -> {
                                q.offer(Pair(nx, ny))
                                grid[nx][ny] = 2
                                cnt--
                            }
                        }
                    }
                }
            }
        }
        return when {
            cnt!=0 -> -1
            else -> min
        }
    }
}