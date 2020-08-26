package 프로그래머스.x만큼간격이있는n개의숫자

class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = arrayListOf<Long>()
        var x1=x.toLong()
        repeat(n){
            answer.add(x1)
            x1+=x
        }
        return answer.toLongArray()
    }
}

fun main() {
    val s=Solution()
    val answer=s.solution(2,5)
    for(i in answer)
        print("$i ")
    println()
    val answer2=s.solution(4,3)
    for(i in answer2)
        print("$i ")
    println()
    val answer3=s.solution(-4,2)
    for(i in answer3)
        print("$i ")

}