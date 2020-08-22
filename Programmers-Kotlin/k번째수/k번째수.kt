package 메인디렉.k번째수

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val list= arrayListOf<Int>()
        for(i in commands)
        {
            val tmp=array.slice(i[0]-1 until i[1]).sorted()
            list.add(tmp[i[2]-1])
        }
        answer=list.toIntArray()
        return answer
    }
}

fun main() {
    val a= Solution()
    val arr= intArrayOf(1,5,2,6,3,7,4)
    val tmp=Array(3){ intArrayOf()}
    tmp[0]= intArrayOf(2,5,3)
    tmp[1]= intArrayOf(4,4,1)
    tmp[2]= intArrayOf(1,7,3)
    val abcd= arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(6,7,8))
    for(i in abcd[0].indices)
        print("${abcd[0][i]} " )
    println()
    for(i in abcd[1].indices)
        print("${abcd[1][i]}" )
    println()
    for(i in abcd[2].indices)
        print("${abcd[2][i]} " )


   // val answer=a.solution(arr,tmp)
   // for(i in answer)
   //     print("$i ")
}