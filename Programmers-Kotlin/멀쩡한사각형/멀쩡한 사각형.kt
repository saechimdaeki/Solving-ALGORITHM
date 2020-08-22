package 메인디렉.멀쩡한사각형

class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        for(i in 0 until w)
            answer+=(h.toLong()*i)/w.toLong()
        return answer*2
    }
}

fun main() {
    val s= Solution()
    println(s.solution(8,12))
}