package LeetCode1475

class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val answer= arrayListOf<Int>()
        loop@for (i in 0 until prices.size-1) {
            var check=true
            for(j in i+1 until prices.size){
                if(prices[i]>=prices[j]){
                    check=false
                    answer.add(prices[i]-prices[j])
                    continue@loop
                }
            }
            if(check)
                answer.add(prices[i])
        }
        answer.add(prices[prices.size-1])
        return answer.toIntArray()
    }
}

fun main() {
    val s= Solution()
    val answer1=s.finalPrices(intArrayOf(8,4,6,2,3))
    val answer2=s.finalPrices(intArrayOf(1,2,3,4,5))
    for (i in answer1) {
        print("$i ")
    }
    println()
    for(i in answer2)
        print("$i ")
}