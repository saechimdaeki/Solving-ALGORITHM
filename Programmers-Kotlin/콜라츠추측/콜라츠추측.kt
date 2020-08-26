package 프로그래머스.콜라츠추측

class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var tmpnum:Long=num.toLong()
        while (tmpnum!=1L){
            if(answer>=500)
                return -1
            if(tmpnum%2==0L) {
                tmpnum /= 2
                answer++
            }else{
               tmpnum=(tmpnum*3)+1
                answer++
            }
        }
        return answer
    }

}

fun main() {
    val s= Solution()
    println(s.solution(6))
    println(s.solution(16))
    println(s.solution(626331))
}