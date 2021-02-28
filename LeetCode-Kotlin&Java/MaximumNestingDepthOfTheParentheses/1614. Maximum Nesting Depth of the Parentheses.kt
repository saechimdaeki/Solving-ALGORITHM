package MaximumNestingDepthOfTheParentheses

import java.util.*

class Solution {
    fun maxDepth(s: String): Int {
        val ans= arrayListOf<Int>()
        ans.add(0)
        val st=Stack<Char>()
        var cnt=0
        loop@ for(i in s.indices){
            when {
                s[i]=='(' -> {
                    st.push('(')
                    cnt++
                }
                s[i]==')' -> {
                    ans.add(cnt)
                    st.pop()
                    cnt--
                }
                else -> continue@loop
            }
        }
        return ans.max()!!
    }
}