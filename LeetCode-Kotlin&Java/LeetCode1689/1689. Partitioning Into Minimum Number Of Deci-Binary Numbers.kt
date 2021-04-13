package LeetCode1689

class Solution {
    fun minPartitions(n: String): Int {
        val arr=IntArray(n.length+1){-1}
        n.indices.forEach { i ->
            arr[i]=n[i]-'0'
        }
        return arr.max()!!
    }
}

fun main() {
    val s=Solution()
    println("${s.minPartitions("32")}") //3
    println("${s.minPartitions("82734")}") //8
    println("${s.minPartitions("27346209830709182346")}") //9
}