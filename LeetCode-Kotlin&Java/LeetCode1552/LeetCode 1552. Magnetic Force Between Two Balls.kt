package LeetCode1552

class Solution {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()
        var answer=0
        var (left,right) = arrayOf(0, position[position.size-1] - position[0]+1)
        while (left<right){
            val mid =left+(right-left)/2
            when {
                possible(position,mid,m) -> {
                    answer =mid
                    left=mid+1
                }
                else -> right=mid
            }
        }
        return answer
    }

    private fun possible(position: IntArray, mid: Int, m: Int): Boolean {
        var (cnt,prev) = arrayOf(1,position[0])
        (1 until position.size).forEach { i ->
            when {
                position[i] - prev >=mid -> {
                    cnt++
                    prev=position[i]
                }
            }
        }
        return cnt>=m
    }


}

fun main() {
    val s= Solution()
    println(s.maxDistance(intArrayOf(1,2,3,4,7),3)) //3
    println(s.maxDistance(intArrayOf(5,4,3,2,1,1000000000),2)) //999999999
}