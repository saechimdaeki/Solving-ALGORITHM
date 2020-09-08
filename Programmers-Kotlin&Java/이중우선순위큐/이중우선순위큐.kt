package 프로그래머스.이중우선순위큐

import java.util.*
import kotlin.math.max

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val maxq=PriorityQueue<Int>(reverseOrder())
        val minq=PriorityQueue<Int>()
        for(i in operations.indices){
            val (op,num)=operations[i].split(" ");
            if(op=="I"){
                maxq.offer(num.toInt())
                minq.offer(num.toInt())
            }else if(op=="D"){
                if(num=="1") {
                    val tmp=maxq.peek()
                    maxq.remove(tmp)
                    minq.remove(tmp)
                }else{
                    val tmp=minq.peek()
                    maxq.remove(tmp)
                    minq.remove(tmp)
                }
            }
        }
        if(maxq.isEmpty())
            return intArrayOf(0,0)
        return intArrayOf(maxq.poll(),minq.poll())
    }
}

fun main() {
   // val s=Solution()
   // val a=s.solution(arrayOf("I 16","D 1"))
   // for(i in a)
    //    print("$i ")
   // val s2=Solution()
   // val b=s2.solution(arrayOf("I 7","I 5","I -5","D -1"))
   // for(i in b)
   //     print("$i ")
    val s=Solution()
    val c=s.solution(arrayOf("I 16","I -5643","D -1","D 1","D 1","I 123","D -1"))
    for(i in c)
        print("$i ")
}