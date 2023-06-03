package 코틀린.연속부분수열합의개수

class Solution {
    fun solution(elements: IntArray): Int {
        val circle = elements + elements
        elements.indices.forEach { i ->
            circle[i + elements.size] = elements[i]
            circle[i] = circle[i + elements.size]
        }
        val set = mutableSetOf<Int>()

        (1.. elements.size).forEach { i ->
            elements.indices.mapTo(set) { circle.sliceArray(it until it + i).sum() }
        }
        return set.size
    }
}

fun main() {
    Solution().apply {
        println(solution(intArrayOf(7,9,1,1,4))) // 18
    }
}