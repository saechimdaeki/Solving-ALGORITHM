package LeetCode1894

class Solution {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        val sum = chalk
            .asSequence()
            .map { it.toLong() }
            .sum()
        var left = k % sum
        chalk.indices.forEach { i ->
            when {
                left >= chalk[i] -> {
                    left -= chalk[i]
                }
                else -> return i
            }
        }
        return -1
    }
}

fun main() {
    val s = Solution()
    println(s.chalkReplacer(intArrayOf(5, 1, 5), 22)) // 0
    println(s.chalkReplacer(intArrayOf(3, 4, 1, 2), 25)) //1

}