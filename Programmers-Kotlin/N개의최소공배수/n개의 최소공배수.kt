package 메인디렉.N개의최소공배수

class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr[0]
        for(i in 1 until arr.size)
            answer=lcm(answer,arr[i])
        return answer
    }
    fun gcd(a:Int,b:Int):Int{
        if(b==0)
            return a
        return gcd(b,a%b)
    }
    fun lcm(a:Int,b:Int):Int{
        return a*b/gcd(a,b)
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(2,6,8,14)))
    println(s.solution(intArrayOf(1,2,3)))
}