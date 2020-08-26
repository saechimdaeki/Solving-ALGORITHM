package 프로그래머스.키패드누르기

import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var left=10
        var right=12
        for(i in numbers.indices){
            when {
                numbers[i]==1 || numbers[i]==4 || numbers[i]==7 -> {
                    answer+="L"
                    left=numbers[i]
                }
                numbers[i]==3 || numbers[i]==6 || numbers[i]==9 -> {
                    answer+="R"
                    right=numbers[i]
                }
                else -> {
                    val distl=dist(left,numbers[i])
                    val distr=dist(right,numbers[i])
                    when {
                        distl>distr -> {
                            answer+="R"
                            right=numbers[i]
                        }
                        distl<distr -> {
                            answer+="L"
                            left=numbers[i]
                        }
                        else -> {
                            when (hand) {
                                "left" -> {
                                    answer+="L"
                                    left=numbers[i]
                                }
                                else -> {
                                    answer+="R"
                                    right=numbers[i]
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer
    }
    fun dist(loc:Int,num:Int):Int{
        var num1=num
        var loc1=loc
        if(num==0)
            num1=11
        if(loc==0)
            loc1=11
        val locx=(loc1-1)/3
        val locy=(loc1-1)%3

        val numx=(num1-1)/3
        val numy=(num1-1)%3
        return abs(locx-numx)+abs(locy-numy)
    }
}

fun main() {
    val s=Solution()
   // println(s.solution(intArrayOf(1,3,4,5,2,8,2,1,4,5,9,5),"right"))
    println(s.solution(intArrayOf(7,0,8,2,8,3,1,5,7,6,2),"left"))
   // println(s.solution(intArrayOf(1,2,3,4,5,6,7,8,9,0),"right"))
}