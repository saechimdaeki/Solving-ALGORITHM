package SplitAStringInBalancedStrings

class Solution {
    fun balancedStringSplit(s: String): Int {
        var sum=0
        var ans=0
        s.forEach {
            when (it) {
                'R' -> sum++
                else -> sum--
            }
            when (sum) {
                0 -> ans++
            }
        }
        return ans
    }
}