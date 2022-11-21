package LeetCode542

import java.util.LinkedList

class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val dx = arrayOf(0,0,1,-1)
        val dy = arrayOf(1,-1,0,0)
        val (x,y) = arrayOf(mat.size, mat[0].size)
        val visited = Array(x){IntArray(y){0}}
        val q = LinkedList<Pair<Int,Int>>()
        (0 until x).forEachIndexed { _, i ->
            (0 until y).forEachIndexed { _, j ->
                when {
                    mat[i][j] == 0 -> {
                        q.offer(Pair(i, j))
                        visited[i][j] = 1
                    }
                }
            }
        }
        var s=1
        while (q.isNotEmpty()) {
            val size = q.size
            (0 until size).forEach { i ->
                val poll = q.poll()
                val (nowx,nowy) = arrayOf(poll.first, poll.second)
                (0 until 4).forEach { j ->
                    val (nx, ny) = arrayOf(nowx+dx[j], nowy + dy[j])
                    if(nx in 0 until x && ny>=0 && ny < y && visited[nx][ny]==0) {
                        visited[nx][ny]=1
                        mat[nx][ny]=s
                        q.offer(Pair(nx,ny))
                    }
                }
            }
            s++
        }
        return mat
    }
}