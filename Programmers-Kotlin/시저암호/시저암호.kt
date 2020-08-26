package 프로그래머스.시저암호

class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        for(i in s.indices){
            answer += when {
                s[i] in 'a'..'z' -> {
                    ((s[i].toInt()+n-'a'.toInt())%26+'a'.toInt()).toChar()
                }
                s[i] in 'A'..'Z' -> {
                    ((s[i].toInt()+n-'A'.toInt())%26+'A'.toInt()).toChar()
                }
                else -> {
                    s[i]
                }
            }
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution("AB",1))
    println(s.solution("z",1))
    println(s.solution("a B z",4))
}