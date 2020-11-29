package 릿코드.PalindromeNumber

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if(x<0) return false
        val s=x.toString()
        return s==s.reversed()
    }
}