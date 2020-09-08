package 프로그래머스.하샤드수

class Solution {
    fun solution(x: Int): Boolean {
        val tmp=x.toString()
        var sum=0
        for(i in tmp.indices)
            sum+=tmp[i]-'0'
        return x%sum==0
    }
}

fun main() {
    val s=Solution()
    println(s.solution(10))
    println(s.solution(12))
    println(s.solution(11))
    println(s.solution(13))
}