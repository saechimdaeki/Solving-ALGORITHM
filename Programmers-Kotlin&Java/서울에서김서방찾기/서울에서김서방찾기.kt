package 메인디렉.서울에서김서방찾기

class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = "김서방은 "
        var idx=0
        for(i in seoul.indices) {
            if (seoul[i] == "Kim") {
                idx=i
                break
            }
        }
        answer+="${idx}에 있다"
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(arrayOf("Jane","Kim")))
}