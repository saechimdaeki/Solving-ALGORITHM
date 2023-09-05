package 코틀린.programmers.전력망을_둘로_나누기

import java.util.LinkedList
import kotlin.math.absoluteValue

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        val grid = Array(n + 1) { mutableListOf<Int>() }

        wires.indices.forEach { i ->
            grid[wires[i][0]].add(wires[i][1])
            grid[wires[i][1]].add(wires[i][0])
        }

        wires.indices.forEach { i ->
            val (from, to) = arrayOf(wires[i][0], wires[i][1])
            val visited = BooleanArray(n + 1)
            grid[from].remove(to)
            grid[to].remove(from)
            var cnt = 1
            val q= LinkedList<Int>()
            q.offer(from)
            while (q.isNotEmpty()) {
                val now = q.poll()
                visited[now] = true
                for (j in grid[now]) {
                    if(!visited[j]) {
                        q.offer(j)
                        cnt ++
                    }
                }
            }
            answer = minOf(answer, (cnt - (n - cnt)).absoluteValue)

            grid[from].add(to)
            grid[to].add(from)
        }

        return answer
    }
}


fun main() {
    Solution().apply {
        println(solution(9, arrayOf(intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(4,6), intArrayOf(4,7), intArrayOf(7,8), intArrayOf(7,9)))) //3
        println(solution(4, arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4)))) //0
        println(solution(7, arrayOf(intArrayOf(1,2), intArrayOf(2,7), intArrayOf(3,7), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(6,7)))) //1

    }
}