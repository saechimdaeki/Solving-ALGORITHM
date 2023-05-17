package 코틀린.마법의엘리베이터

class Solution {
    fun solution(storey: Int): Int {
        var answer = 0
        var now = storey

        while (now > 0) {
            val current = now % 10
            val next = now / 10 % 10
            if (current < 5) {
                answer += current
            } else if (current == 5) {
                answer += 5
                now += if (next >= 5) 10 else 0
            } else {
                answer += 10 - current
                now += 10
            }
            now/=10
        }

        return answer
    }
}

fun main() {
    Solution().apply {
        println(this.solution(16)) //6
        println(this.solution(2554)) //16
    }
}