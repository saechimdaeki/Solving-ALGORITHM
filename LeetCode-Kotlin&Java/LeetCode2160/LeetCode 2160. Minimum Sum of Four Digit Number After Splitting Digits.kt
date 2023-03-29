package LeetCode2160

class Solution {
    fun minimumSum(num: Int): Int {
        val list = mutableListOf<Char>()
        num.toString().forEach { list.add(it) }
        list.sort()
        val n =  (""+ list[0]+ list[2] ).toInt()
        val m = ( ""+ list[1]+ list[3] ).toInt()
        return n+m
    }
}