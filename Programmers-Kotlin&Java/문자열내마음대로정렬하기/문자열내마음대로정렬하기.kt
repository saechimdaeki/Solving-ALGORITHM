package 메인디렉.문자열내마음대로정렬하기

class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = arrayOf<String>()
        val tmp= compareBy<String>{it[n]}
        val tmp2=tmp.thenBy { it }
        answer=strings.sortedWith(tmp2).toTypedArray()

        return answer
    }
}

fun main() {
    val a=Solution()
    val arr1= arrayOf("sum","bed","car")
    val arr2= arrayOf("abce","abcd","cdx")
    val answer1=a.solution(arr1,1)
    for( i in answer1)
        print("$i ")
    println()
    val answer2=a.solution(arr2,2)
    for(i in answer2)
        print("$i ")
    println()
}