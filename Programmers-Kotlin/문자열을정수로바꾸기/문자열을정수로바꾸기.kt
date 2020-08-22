package 메인디렉.문자열을정수로바꾸기

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        return if(s[0]=='-') {
            val string=s.substring(1,s.length)
            return ("-$string").toInt()
        }
        else {
            val string=s.substring(0,s.length)
            string.toInt()
        }
    }
}

fun main() {
    val s=Solution()
    println(s.solution("1234"))
    println(s.solution("-1234"))
}