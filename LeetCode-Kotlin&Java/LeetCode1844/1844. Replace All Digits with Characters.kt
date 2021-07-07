package LeetCode1844

import java.lang.StringBuilder

class Solution {
    fun replaceDigits(s: String): String {
        var previos=' '
        val sb=StringBuilder()
        for(i in s.indices){
            when {
                s[i] in '0'..'9' -> {
                    with(sb) { append(((previos+(s[i]-'0')).toInt()).toChar()) }
                }
                else -> {
                    previos = s[i]
                    sb.append(s[i])
                }
            }
        }
        return sb.toString()
    }
}