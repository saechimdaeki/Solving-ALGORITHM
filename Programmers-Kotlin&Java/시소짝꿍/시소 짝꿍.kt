package 코틀린.시소짝꿍

class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val sortedWeights = weights.sorted()
        val map = mutableMapOf<Double, Int>()
        // (1:1), (1:2), (2:1), (2:3), (3:2), (3:4), (4:3)
        // 중복제거 한다면 -> 경우의 수 (1,1), (2,3) , (2,4) (3,4)
        sortedWeights.forEach { weight ->
            answer += map.getOrDefault(weight.toDouble(), 0)
            answer += map.getOrDefault(weight * 1.0 / 2, 0)
            answer += map.getOrDefault(weight * 2.0 / 3, 0)
            answer += map.getOrDefault(weight * 3.0 / 4, 0)
            map[weight.toDouble()] = map.putIfAbsent(weight.toDouble(), 0)?.let { it + 1 } ?: 1
        }
        return answer
    }
}

fun main() {
    Solution().apply {
        println(solution(intArrayOf(100, 180, 360, 100, 270))) // 4
    }
}