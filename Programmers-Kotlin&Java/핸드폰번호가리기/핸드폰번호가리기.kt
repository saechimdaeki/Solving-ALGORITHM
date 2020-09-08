package 프로그래머스.핸드폰번호가리기

class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        for(i in phone_number.indices){
            if(phone_number.length-i<=4)
                answer+=phone_number[i]
            else
                answer+="*"
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution("01033334444"))
    println(s.solution("027778888"))
}
