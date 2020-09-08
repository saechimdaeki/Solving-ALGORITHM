package 프로그래머스.타겟넘버

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers,target,0,0)
    }
    fun dfs(numbers: IntArray,target: Int,sum:Int,cnt:Int):Int{
        if(cnt==numbers.size){
            if(sum==target)
                return 1
            return 0
        }
        return dfs(numbers,target,sum+numbers[cnt],cnt+1)+dfs(numbers, target, sum-numbers[cnt], cnt+1)
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(1,1,1,1,1),3))
}