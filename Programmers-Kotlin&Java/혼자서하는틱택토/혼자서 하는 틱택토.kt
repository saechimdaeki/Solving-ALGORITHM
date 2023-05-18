package 코틀린.혼자서하는틱택토

class Solution {
    fun solution(board: Array<String>): Int {
        var xCount = 0
        var oCount = 0
        board.forEach { s ->
            s.count { it == 'X' }.let { xCount += it }
            s.count { it == 'O' }.let { oCount += it }
        }

        if (xCount - oCount > 0 || oCount - xCount > 1)
            return 0

        val oCheck = check('O', board)
        val xCheck = check('X', board)
        return when {
            oCheck && xCount + 1 != oCount -> 0
            xCheck && xCount != oCount -> 0
            else -> 1
        }
    }

    fun check(player: Char, board: Array<String>): Boolean {

        // 가로
        for (i in 0 until 3) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true
        }

        // 세로
        for (i in 0 until 3) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true
        }

        // 대각선
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true
        return board[2][0] == player && board[1][1] == player && board[0][2] == player
    }
}


fun main() {
    Solution().apply {
        println(solution(arrayOf("O.X", ".O.", "..X"))) // 1
        println(solution(arrayOf("OOO", "...", "XXX"))) // 0
        println(solution(arrayOf("...", ".X.", "..."))) // 0
        println(solution(arrayOf("...", "...", "..."))) // 1
    }
}