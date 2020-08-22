package 메인디렉.나누어떨어지는숫자배열

class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = arrayListOf<Int>()
        for(i in arr.indices)
        {
            if(arr[i]%divisor==0)
                answer.add(arr[i])
        }
        if(answer.size==0)
            answer.add(-1)
        return answer.sorted().toIntArray()
    }
}
fun main() {
    val s=Solution()
    val answer1=s.solution(intArrayOf(5,9,7,10),5)
    for(i in answer1)
        print("$i ")
    println()
    val answer2=s.solution(intArrayOf(2,36,1,3),1)
    for(i in answer2)
        print("$i ")
    println()

    val answer3=s.solution(intArrayOf(3,2,6),10)
    for(i in answer3)
        print("$i ")
    println()
}