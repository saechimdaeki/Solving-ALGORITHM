package LeetCode227

import java.util.*

/* 227. Basic Calculator II */
class Solution {
    fun calculate(s: String): Int {
        val st=Stack<Int>()
        var now=0
        var ch='+'
        var ans=0
        for(i in s.indices){
            val nowChar = s[i]
            if(nowChar.isDigit()){
                now = (now*10)+ (nowChar-'0')
            }
            else if(nowChar=='+' || nowChar=='-' || nowChar=='*' || nowChar=='/'){
                when (ch) {
                    '+' -> st.push(now)
                    '-' -> st.push(-now)
                    '*' -> {
                        val pop = st.pop()
                        st.push(pop*now)
                    }
                    else -> {
                        val pop = st.pop()
                        st.push(pop/now)
                    }
                }
                now=0
                ch=nowChar
            }
        }
        if(now!=0){
            when (ch) {
                '+' -> st.push(now)
                '-' -> st.push(-now)
                '*' -> {
                    val pop = st.pop()
                    st.push(pop*now)
                }
                else -> {
                    val pop = st.pop()
                    st.push(pop/now)
                }
            }
        }
        while (st.isNotEmpty())
            ans+=st.pop()
        return ans
    }
}