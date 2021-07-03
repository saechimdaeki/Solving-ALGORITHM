package 릿코드.LeetCode1816

class Solution {
    fun truncateSentence(s: String, k: Int): String {
        val split = s.split(" ")
        val sb=StringBuffer()
        (0 until k).forEach { i ->
             with(sb) { append(split[i]).append(" ") }
        }
        return sb.substring(0,sb.length-1)
    }
}