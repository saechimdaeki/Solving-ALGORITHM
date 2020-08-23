package 메인디렉.JadenCase문자열만들기
class Solution { //공백두번연속올수있음에 주의
    fun solution(s: String): String {
        var answer = ""
        val list=s.split(" ")
        for(i in list.indices)
        {
            for(j in list[i].indices)
            {
                answer += if(j==0)
                    list[i][j].toUpperCase()
                else
                    list[i][j].toLowerCase()
            }
            if(i!=list.size-1)
                answer+=" "
        }
       // if(s.endsWith(' '))
           // answer+=" "
        return answer
    }
}
fun main() {
    val s=Solution()
    println(s.solution("3people unFollowed me"))
    println(s.solution("for the last week"))
    println(s.solution("1234 gggg"))
    println(s.solution("AAAAAAA"))
    println(s.solution("Hello World"))
    println(s.solution("Hello  World"))
    println(s.solution("Hello world "))
}