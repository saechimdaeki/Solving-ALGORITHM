package LeetCode1641

class Solution {
    var ans=0
    fun countVowelStrings(n: Int): Int {
        dfs(0,n)//aeiou
        return ans
    }
    fun dfs(idx:Int,n:Int){
        when (n) {
            0 -> {
                ans++
                return
            }
            else -> {
                for (i in idx until 5) //aeiou
                    dfs(i, n - 1)
                return
            }
        }
    }
}