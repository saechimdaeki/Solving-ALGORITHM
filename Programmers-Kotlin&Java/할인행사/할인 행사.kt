package 코틀린.할인행사

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0

        val map = mutableMapOf<String, Int>()

        want.indices.forEach { i ->
            map[want[i]] = number[i]
        }

        (0 until discount.size - 10 +1).forEach { i ->
            val discountMap = mutableMapOf<String, Int>()

            (0 until 10).forEach { j ->
                discountMap[discount[i + j]] = discountMap.getOrDefault(discount[i + j], 0) + 1
            }

            var isOk = true

            for((key, value) in discountMap) when {
                map[key] != value -> {
                    isOk = false
                    break
                }
            }
            answer += when {
                isOk -> 1
                else -> 0
            }
        }

        return answer
    }
}

fun main() {
    Solution().apply {
        println(solution(arrayOf("banana", "apple", "rice", "pork", "pot"), intArrayOf(3,2,2,2,1), arrayOf("chicken", "apple",
            "apple", "banana", "rice", "apple",
            "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"))) // 3

        println(solution(arrayOf("apple"), intArrayOf(10), arrayOf("banana", "banana",
            "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"))) // 0
    }
}