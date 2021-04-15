package LeetCode20

import java.util.*


class Solution {
    fun isValid(s: String): Boolean {
        val map= mutableMapOf<Char,Char>()
        map['(']=')'
        map['{']='}'
        map['[']=']'
        val st=Stack<Char>()
        for (i in s.indices) {
            if(map.containsKey(s[i]))
                st.push(map[s[i]])
            else{
                if(st.isEmpty()) return false
                if(st.pop()!=s[i]) return false
            }
        }
        if(st.isNotEmpty()) return false
        return true
    }
}