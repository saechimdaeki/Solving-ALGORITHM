package 코틀린.테이블해시함수

class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer = 0
        val column = col -1
        val rowBegin = row_begin -1
        data.sortWith(compareBy({it[column]}, { -it[0] }))

        (rowBegin until row_end).forEach { i ->
            val fianl = i+1
            val sum = data[i].sumOf { it % fianl }
            answer = (answer xor sum)
        }

        return answer
    }
}

fun main() {
    Solution().apply {
        println(solution(arrayOf(intArrayOf(2,2,6), intArrayOf(1,5,10), intArrayOf(4,2,9), intArrayOf(3,8,3)),2,2,3)) //4
     }
}