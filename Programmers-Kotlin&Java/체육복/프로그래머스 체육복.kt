package 메인디렉.체육복

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val arr=Array(n+1){1}
        for(i in lost.indices)
            arr[lost[i]]--
        for(i in reserve.indices)
            arr[reserve[i]]++
        for(i in 1..n)
        {
            if(arr[i]==0)
            {
                if(arr[i-1]==2)
                {
                    arr[i-1]--
                    arr[i]=1
                }else if(i+1<=n){
                    if(arr[i+1]==2) {
                        arr[i + 1]--
                        arr[i] = 1
                    }
                }
            }
        }
        var answer=0
        for(i in 1..n)
        {
            if(arr[i]>0)
             answer++
        }
        return answer
    }
}


fun main() {
    val s= Solution()
    println(s.solution(5, intArrayOf(2,4), intArrayOf(1,3,5)))
    println(s.solution(5, intArrayOf(2,4), intArrayOf(3)))
    println(s.solution(3, intArrayOf(3), intArrayOf(1)))
}