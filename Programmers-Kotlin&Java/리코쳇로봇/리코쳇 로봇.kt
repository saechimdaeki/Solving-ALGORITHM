package 코틀린.리코쳇로봇

import java.util.LinkedList

class Solution {
    val dx = arrayOf(1,-1,0,0)
    val dy = arrayOf(0,0,1,-1)
    fun solution(board: Array<String>): Int {
        var (sx, sy) = arrayOf(0, 0)
        val x = board.size
        val y = board[0].length
        board.indices.forEach { i ->
            board[i].indices.forEach { j ->
                if (board[i][j] == 'R') {
                    sx = i
                    sy = j
                }
            }
        }

        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(sx, sy))
        val dist = Array(x){IntArray(y)}
        dist[sx][sy] = 1
        while (q.isNotEmpty()) {
            val (nowx,nowy) = q.poll()
            if (board[nowx][nowy] == 'G')
                return dist[nowx][nowy] -1

            for (i in 0 until 4) {
                var nx = nowx
                var ny = nowy
                while (true) {
                    nx += dx[i]
                    ny += dy[i]
                    if (nx< 0 || ny< 0 || nx>= x || ny>=y) {
                        nx-=dx[i]
                        ny-=dy[i]
                        break
                    }
                    if (board[nx][ny] == 'D') {
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                    }
                }
                if (dist[nx][ny] == 0){
                    dist[nx][ny] = dist[nowx][nowy] +1
                    q.offer(Pair(nx,ny))
                }
            }
        }

        return -1
    }
}

fun main() {
    Solution().apply {
        println(this.solution(arrayOf("...D..R", ".D.G...", "....D.D", "D....D.", "..D...."))) // 7
        println(this.solution(arrayOf(".D.R", "....", ".G..", "...D"))) // -1
    }
}