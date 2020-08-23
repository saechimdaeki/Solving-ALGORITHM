package 메인디렉.큰수만들기

import java.lang.StringBuilder


class Solution {

    fun solution(number: String, k: Int): String {
        var answer =StringBuilder()
        var cnt=number.length-k
        var max=-1
        var right=number.length-cnt
        var left=0
        var idx=0
        while (cnt>0){
            max=-1
            for(i in left ..right){
                val n=number[i]-'0'
                if(n>max){
                    idx=i
                    max=n
                }
            }
            answer.append(number[idx])
            left=idx+1
            cnt--
            right=number.length-cnt
        }
        return answer.toString() //그냥 string으로할시 테케9 시간초과..
    }
}

fun main() {
    val s=Solution()
    println(s.solution("1924",2))
    println(s.solution("12311234",3))
    println(s.solution("4177252841",4))
}