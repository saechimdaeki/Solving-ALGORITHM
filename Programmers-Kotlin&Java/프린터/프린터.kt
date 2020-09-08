package 메인디렉.프린터

import java.util.*


class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val pq=PriorityQueue<Int>()
        for(i in priorities)
            pq.add(-i)
        while (pq.isNotEmpty())
        {
            for(i in priorities.indices)
            {
                if(priorities[i]==-pq.peek())
                {
                    if(i==location)
                        return answer+1
                    pq.poll()
                    answer++
                }
            }
        }


        return answer+1
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(2,1,3,2),2))
    println(s.solution(intArrayOf(1,1,9,1,1,1),0))

}