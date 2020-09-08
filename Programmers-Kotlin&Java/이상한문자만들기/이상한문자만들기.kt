package 프로그래머스.이상한문자만들기

class Solution {
    fun solution(s: String): String {
        var answer = ""
        val tmp=s.split(" ")
        for(i in tmp.indices)
        {
            for(j in tmp[i].indices){
                answer += if(j%2==0)
                    tmp[i][j].toUpperCase()
                else
                    tmp[i][j].toLowerCase()
            }
            if(i!=tmp.size-1)
            answer+=" "
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution("try hello world"))
}