package LeetCode557

class Solution {
    fun reverseWords(s: String): String {
        StringBuilder()
            .run {
                s.split(" ").forEachIndexed { index, it ->
                    this.append(it.reversed())
                        .append(" ")
                }
                this.setLength(s.length)
                return this.toString()
            }
    }
}

fun main() {
    Solution().apply {
        println(reverseWords("Let's take LeetCode contest")) // "s'teL ekat edoCteeL tsetnoc"
        println(reverseWords("God Ding")) // "doG gniD"
    }
}