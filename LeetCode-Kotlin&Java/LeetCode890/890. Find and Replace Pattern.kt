package LeetCode890

import java.lang.StringBuilder
import java.util.HashMap

class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val answer = arrayListOf<String>()
        val s = findPattern(pattern)
        words.indices
            .filter { words[it].length == pattern.length &&
                    s == findPattern(words[it]) }
            .mapTo(answer) { words[it] }
        return answer.toList()
    }
    private fun findPattern(str: String): String {
        var count = 0
        val map = HashMap<Char, Int>()
        val ans = StringBuilder()
        str.indices.forEach { i ->
            when {
                map.containsKey(str[i]) -> {
                    ans.append(map[str[i]])
                }
                else -> {
                    count++
                    map[str[i]] = count
                    ans.append(count)
                }
            }
        }
        return ans.toString()
    }
}



fun main() {
    val s= Solution()
    val answer1=s.findAndReplacePattern(arrayOf("abc","deq",
        "mee","aqq","dkd","ccc"),"abb")
    for (s in answer1) {
        print("$s ")
    }
    println()

}

