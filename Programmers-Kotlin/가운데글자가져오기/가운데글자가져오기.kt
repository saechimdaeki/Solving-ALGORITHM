package 메인디렉.가운데글자가져오기

class Solution {
    fun solution(s: String): String {
        var answer = ""
        if(s.length%2==0)
        {
            answer+=s[s.length/2-1]
            answer+=s[s.length/2]
        }else
            answer+=s[s.length/2]
        return answer
    }
}

fun main() {
    val a= Solution()
    val s1="abcde"
    val s2="qwer"
    println(a.solution(s1))
    println(a.solution(s2))
}