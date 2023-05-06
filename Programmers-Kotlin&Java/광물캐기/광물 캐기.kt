package 코틀린.광물캐기


class Solution {
    var answer = Int.MAX_VALUE
    val map = mapOf(Pair("diamond", listOf(1,5,25)),Pair("iron", listOf(1,1,5)),Pair("stone", listOf(1,1,1)))

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        dfs(0,minerals.size, 0, picks , minerals )
        return answer
    }

    fun dfs(idx: Int, size: Int, sum: Int, picks: IntArray, minerals: Array<String>) {
        if (idx == size || picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = minOf(answer, sum)
            return
        }

        for (i in 0 until 3) {
            if (picks[i] == 0) continue
            picks[i]--
            val temp = (idx until minOf(idx + 5, size)).sumOf { map[minerals[it]]!![i] }
            dfs(minOf(idx + 5, size), size, sum + temp, intArrayOf(picks[0], picks[1], picks[2]), minerals)
            picks[i]++
        }
    }
}
