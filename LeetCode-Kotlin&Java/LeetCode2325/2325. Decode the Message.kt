package LeetCode2325

class Solution {
    fun decodeMessage(key: String, message: String): String {
        val map = mutableMapOf<Char,Char>()
        var char = 0
        val answer = StringBuilder()
        key.forEach { c ->
            when {
                c == ' ' || map.containsKey(c) -> return@forEach
                else -> map.put(c,'a'+(char++))
            }
        }
        message.forEach { c ->
            with(answer) { append(if (c==' ')' ' else map[c]) }
        }
        return answer.toString()
    }
}
