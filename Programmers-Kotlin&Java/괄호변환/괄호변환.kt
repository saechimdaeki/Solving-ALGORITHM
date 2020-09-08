package 메인디렉.괄호변환

import java.util.*

class Solution {
    var idx=0
    fun solution(p: String): String {
        if(p.isEmpty())
            return ""
        val barunmoonza=correct(p)
        val u=p.substring(0,idx)
        //println(u)
        val v=p.substring(idx,p.length)
        if(barunmoonza)
            return u+solution(v)
        var answer="("+solution(v)+")"
        for(i in 1 until u.length-1){
            answer+= when {
                u[i] != '(' -> "("
                else -> ")"
            }
        }
        return answer
    }
    private fun correct(p:String):Boolean{
        var check=true
        var (left,right)= intArrayOf(0,0)
        val st=Stack<Char>()
        for(i in p.indices){
            when {
                p[i]=='(' -> {
                    left++
                    st.add('(')
                }
                else -> {
                    right++
                    when {
                        st.isEmpty() -> check=false
                        else -> st.pop()
                    }
                }
            }
            if(left==right){
                idx=i+1
                return check
            }
        }
        return true
    }
}


fun main() {
    val s=Solution()
    println(s.solution("(()())()"))
    println(s.solution(")("))
    println(s.solution("()))((()"))
}