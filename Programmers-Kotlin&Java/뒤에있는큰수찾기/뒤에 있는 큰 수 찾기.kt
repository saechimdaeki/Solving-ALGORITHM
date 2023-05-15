package 코틀린.뒤에있는큰수찾기

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size)
        val s = ArrayDeque<Int>()

        (numbers.size -1 downTo 0).forEach { i ->
            while (s.isNotEmpty()) {
                when {
                    s.last() > numbers[i] -> {
                        answer[i] = s.last()
                        break
                    }
                    else -> {
                        s.removeLast()
                    }
                }
            }
            when {
                s.isEmpty() -> answer[i] = -1
            }
            s.addLast(numbers[i])
        }
        return answer
    }
}

fun main() {
    Solution().apply {
        val solution1 = this.solution(intArrayOf(2, 3, 3, 5))
        println(solution1.contentToString())

        val solution2 = this.solution(intArrayOf(9, 1, 5, 3, 6, 2))
        println(solution2.contentToString())
    }
}