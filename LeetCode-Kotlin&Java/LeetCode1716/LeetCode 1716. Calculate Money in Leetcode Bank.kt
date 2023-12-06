package 코틀린.LeetCode.LeetCode1716

class Solution {
    fun totalMoney(n: Int): Int {
        var answer = 0
        var week = 0
        var day = 0
        (1..n).forEach { _ ->
            day++
            answer += week + day
            when (day) {
                7 -> {
                    week++
                    day = 0
                }
            }
        }
        return answer

    }
}