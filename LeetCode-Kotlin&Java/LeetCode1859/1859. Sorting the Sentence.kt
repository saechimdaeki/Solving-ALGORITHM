package LeetCode1859

import java.util.*


internal class Solution {
    fun sortSentence(s: String): String {
        val inputs = s.split(" ")
        val map: MutableMap<Int, String> = HashMap()
        inputs.forEach { input ->
            val inputSize = input.length
            val indexChar = input[inputSize - 1]
            val indexStr = indexChar.toString()
            val index = indexStr.toInt()
            val `val` = input.substring(0, inputSize - 1)
            map[index] = `val`
        }
        var output = ""
        val treeMap = TreeMap(map)
        val it: Iterator<Map.Entry<Int, String>> = treeMap.entries.iterator()
        while (it.hasNext()) {
            val (_, value) = it.next()
            output += value
            if (it.hasNext()) {
                output += " "
            }
        }
        return output
    }
}