package 메인디렉.행렬의곱셈

class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val n =arr1.size
        val a=arr1[0].size
        val b=arr2[0].size
        var answer = Array(n){ IntArray(b){0} }
        for(i in 0 until n)
        {
            for(j in 0 until b)
            {
                for(k in 0 until a)
                    answer[i][j]+=arr1[i][k]*arr2[k][j]
            }
        }
        return answer
    }
}

fun main() {
    val s= Solution()
    val arr11= arrayOf(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1))
    val arr12= arrayOf(intArrayOf(3,3), intArrayOf(3,3))
    val answer1=s.solution(arr11,arr12)
    val arr21= arrayOf(intArrayOf(2,3,2), intArrayOf(4,2,4), intArrayOf(3,1,4))
    val arr22= arrayOf(intArrayOf(5,4,3), intArrayOf(2,4,1), intArrayOf(3,1,1))

}