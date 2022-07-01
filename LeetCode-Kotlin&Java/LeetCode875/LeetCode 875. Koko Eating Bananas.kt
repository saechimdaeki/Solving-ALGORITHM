package LeetCode875

import kotlin.math.ceil

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // 릿코드는 코틀린 버젼이 낮아서 maxOrNull() -> max로 바꿔야함.
        var (left,right) = arrayOf(1, piles.maxOrNull() ?:1)
        while (left< right){
            val mid =(left+right)/2
            var tmp=0
            piles.forEach { pile -> tmp += ceil((pile.toDouble() / mid)).toInt() }
            when {
                tmp<=h -> right=mid
                else -> left=mid+1
            }
        }
        return right
    }
}

fun main() {
    val s = Solution()
    println(s.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8)) //4
    println(s.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5)) //30
    println(s.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6)) //23
}