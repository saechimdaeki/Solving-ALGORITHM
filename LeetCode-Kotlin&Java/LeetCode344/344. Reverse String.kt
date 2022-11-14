package LeetCode344

class Solution {
    fun reverseString(s: CharArray): Unit {
        var (left,right) = arrayOf(0, s.size-1)

        while (left<right){
            val tmp = s[right]
            s[right]=s[left]
            s[left]=tmp
            left++
            right--
        }
    }
}

