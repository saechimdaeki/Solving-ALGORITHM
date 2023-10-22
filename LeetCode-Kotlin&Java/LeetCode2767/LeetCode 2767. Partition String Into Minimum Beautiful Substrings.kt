package 코틀린.LeetCode.LeetCode2767

class Solution {
    var ans = Int.MAX_VALUE
    fun minimumBeautifulSubstrings(s: String): Int {
        dfs(s, 0, 0)
        return when (ans) {
            Int.MAX_VALUE -> -1
            else -> ans
        }
    }

    fun dfs(target: String, idx: Int, cnt: Int) {
        when (idx) {
            target.length -> {
                ans = minOf(cnt, ans)
                return
            }
            else -> (idx until target.length).forEach { i ->
                val tmp = target.substring(idx, i + 1)
                if (tmp[0] != '0' && isBeautifulFive(tmp)) {
                    dfs(target, i + 1, cnt + 1)
                }
            }
        }
    }

    fun isBeautifulFive(n: String): Boolean {
        var now = n.toInt(2)
        while (now > 1) {
            when {
                now % 5 != 0 -> return false
                else -> now /= 5
            }
        }

        return now == 1
    }

}


fun main() {
    Solution().apply {
        println(minimumBeautifulSubstrings("1011")) //2
        println(minimumBeautifulSubstrings("111")) // 3
        println(minimumBeautifulSubstrings("0")) // -1
    }
}