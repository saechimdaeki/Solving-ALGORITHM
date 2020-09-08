package 프로그래머스.`2016년`
class Solution {
    fun solution(a: Int, b: Int): String {
        val map= mutableMapOf<Int,String>()
        var sum=0
        map[0]="FRI"
        map[1]="SAT"
        map[2]="SUN"
        map[3]="MON"
        map[4]="TUE"
        map[5]="WED"
        map[6]="THU"
        val month= intArrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
        for(i in 0 until a-1)
            sum+=month[i]
        sum+=b-1
        return map[sum%7]!!
    }
}
fun main() {
    val s=Solution()
    println(s.solution(5,24))
}