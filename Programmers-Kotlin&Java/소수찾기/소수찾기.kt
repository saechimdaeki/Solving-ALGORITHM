package 프로그래머스.소수찾기

import kotlin.math.sqrt

class Solution {
    val set=HashSet<Int>()
    lateinit var visited:BooleanArray
    fun solution(numbers: String): Int {
        visited=BooleanArray(numbers.length)
        for(i in numbers.indices)
            dfs(i,numbers,"")
       //val it=set.iterator()
      //  while (it.hasNext())
        //    print("${it.next()} ")
        return set.size
    }
    fun dfs(i:Int,s:String,number:String){
        visited[i]=true
        var number1=number
        number1+=s[i]
        val tmp=number1.toInt()
        if(!set.contains(tmp) && prime(tmp))
            set.add(tmp)
        for(j in s.indices)
            if(!visited[j])
                dfs(j,s,number1)
        visited[i]=false

    }
    fun prime(n:Int):Boolean{
        if(n==1||n==0)
            return false
        var tmp= sqrt(n.toDouble()).toInt()
        for(i in 2..tmp)
        {
            if(n%i==0)
                return false
        }
        return true
    }

}

fun main() {
    val s=Solution()
    //println(s.solution("17"))
    println(s.solution("011"))
}