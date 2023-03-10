package LeetCode2114

class Solution {
    fun mostWordsFound(sentences: Array<String>): Int {
        val list = sentences
            .map { it.split(" ") }
            .map { it.size }
        return list.maxOf { it }

        // 릿 코드에 제출시는 list.max()!! 해야함.
    }
}