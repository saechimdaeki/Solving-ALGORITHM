package 메인디렉.가장큰수

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""
        val arr=Array(numbers.size){""}
        for(i in numbers.indices)
            arr[i]=numbers[i].toString()
        arr.sortedWith(Comparator{data1,data2->(data2+data1).compareTo(data1+data2)})
                .forEach { answer+=it }
        if(answer[0]=='0') //tc 11번
            return "0"
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(6,10,2)))
    println(s.solution(intArrayOf(3,30,34,5,9)))


}