package SumOfAllOddLengthSubarrays

class Solution {
    val list= arrayListOf<Int>()
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        for(i in 1.. arr.size step 2){
            var wid=0
            for(j in 0 until i)
                wid+=arr[j]
            list.add(wid)
            for(j in i until arr.size){
                wid+=arr[j]
                wid-=arr[j-i]
                list.add(wid)
            }
        }
        return list.sum()
    }
}

fun main() {
    val s= Solution()
    println(s.sumOddLengthSubarrays(intArrayOf(1,4,2,5,3)))
}