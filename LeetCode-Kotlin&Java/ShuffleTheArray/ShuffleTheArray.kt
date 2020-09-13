package 릿코드.ShuffleTheArray

import java.util.*

class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val q=LinkedList<Int>()
        val answer=IntArray(nums.size)
        var (x,y)= intArrayOf(0,n)
        var cnt=0
        for(i in 0 until n){
            answer[cnt++]=nums[x++]
            answer[cnt++]=nums[y++]
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    val answer1=s.shuffle(intArrayOf(2,5,1,3,4,7),3)
    for(i in answer1)
        print("$i ")
    println()
    val answer2=s.shuffle(intArrayOf(1,2,3,4,4,3,2,1),4)
    for(i in answer2)
        print("$i ")
}