package LeetCode1419

class Solution {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        var answer = 0
        val arr = IntArray(5)
        var frog =0
        for(i in croakOfFrogs.indices) {
            val c = croakOfFrogs[i]
            val index = "croak".indexOf(c)
            arr[index]++
            when {
                index ==0 -> answer = maxOf(answer, ++frog)
                --arr[index-1]< 0 -> return -1
                index == 4 -> frog--
            }
        }
        return if(frog==0) answer else -1
    }
}

fun main() {
    println(  Solution().minNumberOfFrogs("croakcrook"))
}