package 코틀린.LeetCode.LeetCode419

class Solution {
    fun countBattleships(board: Array<CharArray>): Int {
        var ans = 0
        board.indices.forEach { i ->
            repeat(
                board[i].indices
                    .filter {
                        board[i][it] == 'X' && (i == 0 || board[i - 1][it] != 'X') &&
                                (it == 0 || board[i][it - 1] != 'X')
                    }.size
            ) { ans++ }
        }
        return ans
    }
}

fun main() {
    Solution().apply {
        println(
            countBattleships(
                arrayOf(
                    charArrayOf('X', '.', '.', 'X'),
                    charArrayOf('.', '.', '.', 'X'),
                    charArrayOf('.', '.', '.', 'X')
                )
            )
        ) // 2
        println(countBattleships(arrayOf(charArrayOf('.'))))  // 0
    }
}