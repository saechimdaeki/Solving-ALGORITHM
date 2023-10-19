package 코틀린.LeetCode.LeetCode2379

class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var answer = Int.MAX_VALUE
        var (left,right) = arrayOf(0,0)
        var count = 0
        while (right < blocks.length) {
            when {
                blocks[right] == 'W' -> count++
            }
            when (k) {
                right-left+1 -> {
                    answer = minOf(answer, count)
                    if(blocks[left] == 'W') count--
                    left++
                }
            }
            right++
        }
        return answer
    }
}




fun main() {
    Solution().apply {
        println(minimumRecolors("WBBWWBBWBW", 7)) // 3

        println(minimumRecolors("WBWBBBW", 2)) // 0
    }
}