package 메인디렉.최댓값과최솟값

class Solution {
    fun solution(s: String): String {
        var valuelist=s.split(" ").map{it.toInt()}.toTypedArray()
        valuelist.sort()
        return "${valuelist[0]} ${valuelist[valuelist.size-1]}"
    }
}

fun main() {
    val s=Solution()
    println(s.solution("1 2 3 4"))
    println(s.solution("-1 -2 -3 -4"))
    println(s.solution("-1 -1"))


}