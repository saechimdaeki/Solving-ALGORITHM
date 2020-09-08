package 메인디렉.문자열다루기기본

class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        if(s.length==4||s.length==6) {
            for (i in s.indices) {
                if (s[i] in '0'..'9')
                    ;
                else
                    return false
            }
        }else
            return false
        return answer
    }
}

fun main() {
    val a=Solution()
    println(a.solution("a234"))
    println(a.solution("1234"))
}