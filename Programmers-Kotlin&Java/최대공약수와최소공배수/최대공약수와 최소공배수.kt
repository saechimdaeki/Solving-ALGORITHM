package 프로그래머스.최대공약수와최소공배수

class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val arr= arrayListOf<Int>()
        arr.add(gcd(n,m))
        arr.add(lcm(n,m))
        return arr.toIntArray()
    }
    fun gcd(n1:Int,n2:Int):Int{
        if(n2==0)
            return n1
        return gcd(n2,n1%n2)
    }
    fun lcm(n1:Int,n2:Int):Int{
        return (n1*n2)/gcd(n1,n2)
    }
}

fun main() {
    val s=Solution()
    val answer1=s.solution(3,12)
    for(i in answer1)
        print("$i ")
    println()
    val answer2=s.solution(2,5)
    for(i in answer2)
        print("$i ")
}