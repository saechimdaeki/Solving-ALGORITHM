package 코틀린.LeetCode.LeetCode1921

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val time = IntArray(dist.size)
        dist.indices.forEach { i ->
            time[i] = dist[i] / speed[i] + if (dist[i] % speed[i] == 0) 0 else 1
        }
        time.sort()
        return time.indices
            .takeWhile { time[it] > it }
            .count()
    }
}