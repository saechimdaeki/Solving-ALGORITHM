package 프로그래머스.hindex

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        val tmp=citations.sortedArray()
        for(i in tmp.indices){
            val h=tmp.size-i
            if(tmp[i]>=h){
                return h
            }
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(3,0,6,1,5)))
}