package 코틀린.LeetCode.LeetCode2375

class Solution {

    lateinit var used : MutableSet<Int>
    var answer = ""

    fun smallestNumber(pattern: String): String {
        used = mutableSetOf()
        val n = pattern.length + 1 // 1..n
        for (i in 1..n) {
            val sb = StringBuilder()
            sb.append(i)
            used.add(i)
            if (answer.length < 2)
                dfs(pattern, n, 0, sb)
            sb.deleteAt(sb.length - 1)
            used.remove(i)
        }

        return answer
    }

    fun dfs(pattern: String, n: Int, idx: Int, sb: StringBuilder) {
        if (idx == pattern.length) {
            answer = sb.toString()
            return
        }
        for (i in 1.. n) {
            if(answer.isNotBlank()) return
            if(used.contains(i)) continue
            if (pattern[idx] == 'D' &&  sb[sb.length-1] - '0' < i  ) return
            sb.append(i)
            used.add(i)
            dfs(pattern, n, idx+1, sb)
            sb.deleteAt(sb.length-1)
            used.remove(i)
        }
    }


}

fun main() {
    Solution().apply {
        println(smallestNumber("IIIDIDDD")) // 123549876
        println(smallestNumber("DDD")) // 4321
    }
}