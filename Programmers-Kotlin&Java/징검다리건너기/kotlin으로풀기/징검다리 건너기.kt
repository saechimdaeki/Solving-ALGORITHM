package 프로그래머스.징검다리건너기.kotlin으로풀기

import kotlin.math.max

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var (left,right)= arrayOf(stones.min()!!,stones.max()!!)
        while (left<=right){
            val mid=(left+right)/2
            if(possible(mid,k,stones.clone())){
                answer= max(answer,mid)
                left=mid+1
            }else{
                right=mid-1
            }
        }
        return answer
    }
    fun possible(mid:Int,k:Int,stones: IntArray):Boolean{
        stones.indices.forEach { i ->
            stones[i]-=mid
        }
        var cnt=0
        stones.indices.forEach { i ->
            when {
                stones[i]<0 -> {
                    cnt++
                    if(cnt>=k) return false
                }
                else -> {
                    cnt=0
                }
            }
        }
        return true
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(2,4,5,3,2,1,4,2,5,1),3))
}