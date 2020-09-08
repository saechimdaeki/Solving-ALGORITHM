package 프로그래머스.자연수뒤집어배열로만들기

class Solution {
    fun solution(n: Long): IntArray {
        val list= arrayListOf<Int>()
        val s=n.toString().reversed()
        for(i in s.indices)
            list.add(s[i]-'0')
        return list.toIntArray()
    }
}

fun main() {
    val s=Solution()
    println(s.solution(12345))
}