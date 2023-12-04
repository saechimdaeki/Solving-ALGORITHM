package 코틀린.LeetCode.LeetCode2264


class Solution {
    fun largestGoodInteger(num: String): String {
        var result = Int.MIN_VALUE
        (0 until num.length - 2)
            .asSequence()
            .filter { num[it] == num[it +1] && num[it] == num[it +2] }
            .forEach { result = maxOf(result, num[it]- '0') }
        val builder = StringBuilder()
        for (i in 0..2) builder.append((48 + result).toChar())
        return if (result == Int.MIN_VALUE) "" else builder.toString()
    }
}
