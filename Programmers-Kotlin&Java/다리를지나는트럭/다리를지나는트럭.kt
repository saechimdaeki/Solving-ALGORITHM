package 메인디렉.다리를지나는트럭

import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val wait=LinkedList<Pair<Int,Int>>()
        var now=LinkedList<Pair<Int,Int>>()
        for(i in truck_weights.indices){
            wait.offer(Pair(truck_weights[i],0))
        }
        var sum=0
        while (now.isNotEmpty()||wait.isNotEmpty()){
            answer++
            if(now.isNotEmpty()){
                val truck=now.peek()
                if(answer-truck.second>=bridge_length){
                    sum-=truck.first
                    now.poll()
                }
            }
            if(wait.isNotEmpty()){
                if(sum+wait.peek().first<=weight){
                    val truck=wait.poll()
                    sum+=truck.first
                    now.offer(Pair(truck.first,answer))
                }
            }
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(2,10, intArrayOf(7,4,5,6)))
    println(s.solution(100,100, intArrayOf(100)))
    println(s.solution(100,100, intArrayOf(10,10,10,10,10,10,10,10,10,10)))
}