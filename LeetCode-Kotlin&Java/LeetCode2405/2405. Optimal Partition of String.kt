package LeetCode2405

class Solution {
    fun partitionString(s: String): Int {
        var answer = 0
        val stringSet = mutableSetOf<Char>()
        s.indices.forEach { i ->
            when {
                stringSet.contains(s[i]) -> {
                    answer++
                    stringSet.clear()
                }
            }
            stringSet.add(s[i])
        }
        return stringSet.run {
            when {
                this.isEmpty() -> answer
                else -> answer + 1
            }
        }
    }
}