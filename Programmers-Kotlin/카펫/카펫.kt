package 메인디렉.카펫

class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = arrayListOf<Int>()
        val mul=brown+yellow
        for(i in 1..mul/2)
        {
            if(mul%i==0) {
                val m=mul/ i
                if(i <m) continue
                val tmp=(i -2)*(m-2)
                val tmp2=mul-tmp
                if(tmp==yellow&&tmp2==brown){
                    answer.add(i)
                    answer.add(m)
                    break
                }
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val tmp1=s.solution(10,2)
    for(i in tmp1)
        print("$i ")
    println()
    val tmp2=s.solution(8,1)
    for(i in tmp2)
        print("$i ")
    println()
    val tmp3=s.solution(24,24)
    for(i in tmp3)
        print("$i ")

}