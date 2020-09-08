package 메인디렉.수박수박수박수박수

class Solution {
    fun solution(n: Int): String {
        var answer = ""
        for(i in 1 .. n)
        {
            answer += if(i%2!=0)
                "수"
            else
                "박"
        }
        return answer
    }
}

fun main() {
    val s= Solution()
    println(s.solution(3))
    println(s.solution(4))
}