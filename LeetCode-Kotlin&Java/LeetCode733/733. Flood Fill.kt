package LeetCode733

import java.util.*

class Solution {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val target = image[sr][sc]
        image[sr][sc] = color
        if (target == color)
            return image

        val q = LinkedList<Pair<Int, Int>>().also {
            it.add(Pair(sr, sc))
        }
        while (q.isNotEmpty()) {
            val poll = q.poll()
            val (nowx, nowy) = arrayOf(poll.first, poll.second)
            (0 until 4).forEach { i ->
                val (nx, ny) = arrayOf(nowx + dx[i], nowy + dy[i])
                when {
                    nx < image.size && nx >= 0 && ny < image[0].size && ny >= 0 && image[nx][ny] == target -> {
                        image[nx][ny] = color
                        q.add(Pair(nx, ny))
                    }
                }
            }
        }
        return image
    }

}

