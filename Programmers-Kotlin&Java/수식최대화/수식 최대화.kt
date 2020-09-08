package 프로그래머스.수식최대화

import kotlin.math.abs
import kotlin.math.max

class Solution {
    var oper = charArrayOf('+', '-', '*')
    var visited = BooleanArray(3)
    var numbers= arrayListOf<Long>()
    var opers= arrayListOf<Char>()
    var answer: Long = 0
    fun solution(expression: String): Long {
        answer = 0
        var num = ""
        for (i in expression.indices) {
            if (expression[i] in '0'..'9') {
                num += expression[i]
            } else {
                numbers.add(num.toLong())
                opers.add(expression[i])
                num = ""
            }
            if(i==expression.length-1)
                numbers.add(num.toLong())
        }
        dfs(0, CharArray(3))
        return answer
    }
    fun dfs(count: Int, op: CharArray) {
        if (count == 3) {
            val nums = ArrayList(numbers)
            val opers = ArrayList(opers)
            for (i in op.indices) {
                var j = 0
                while (j < opers.size) {
                    if (opers[j] == op[i]) {
                        val res = calc(nums.removeAt(j), nums.removeAt(j), op[i])
                        nums.add(j, res)
                        opers.removeAt(j)
                        j--
                    }
                    j++
                }
            }
            answer = max(answer, abs(nums[0]))
            return
        }
        for (i in 0..2) {
            if (!visited[i]) {
                visited[i] = true
                op[count] = oper[i]
                dfs(count + 1, op)
                visited[i] = false
            }
        }
    }
    fun calc(num1: Long, num2: Long, oper: Char): Long {
        return when (oper) {
            '*' -> {
                num1 * num2
            }
            '+' -> {
                num1 + num2
            }
            else -> {
                num1 - num2
            }
        }
    }
}

fun main() {
    val s=Solution()
    println(s.solution("100-200*300-500+20"))
   // println(s.solution("50*6-3*2"))
}