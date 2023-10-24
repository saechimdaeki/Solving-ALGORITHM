package 코틀린.programmers.가장먼노드

import java.util.LinkedList


class Solution {
    lateinit var grid : Array<MutableList<Int>>
    lateinit var dist: IntArray
    lateinit var visited : BooleanArray
    fun solution(n: Int, edge: Array<IntArray>): Int {
        grid = Array(n + 1) { mutableListOf() }
        dist = IntArray(n + 1) { -1 }
        visited = BooleanArray(n + 1)
        edge.forEach { ints ->
            val from = ints[0]
            val to = ints[1]
            grid[from].add(to)
            grid[to].add(from)
        }
        dfs(1)
        dist.sortDescending()
        val max = dist[0]
        return dist.count { it == max }
    }

    fun dfs(n:Int) {
        val q= LinkedList<Int>()
        q.offer(n)
        dist[n] = 0
        visited[n] = true
        while (q.isNotEmpty()) {
            val now = q.poll()
            for(i in 0 until grid[now].size) {
                if(!visited[grid[now][i]]) {
                    dist[grid[now][i]] = dist[now]+1
                    visited[grid[now][i]] = true
                    q.offer(grid[now][i])
                }
            }
        }
    }
}

fun main() {
    Solution().apply {
        println(
            solution(
                6, arrayOf(
                    intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3), intArrayOf(1, 2),
                    intArrayOf(2, 4), intArrayOf(5, 2)
                )
            )
        ) // 3
    }
}