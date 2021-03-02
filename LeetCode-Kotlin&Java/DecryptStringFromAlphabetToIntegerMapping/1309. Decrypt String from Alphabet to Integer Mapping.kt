package DecryptStringFromAlphabetToIntegerMapping

import java.lang.StringBuilder

class Solution {
    fun freqAlphabets(s: String): String {
        val ans=StringBuilder()
        var index=0
       while (index<s.length){
           var now=0
           when {
               index+2<s.length &&s[index+2]=='#' -> {
                   now=s.substring(index,index+2).toInt()
                   index+=3
               }
               else -> {
                   now=s.substring(index,index+1).toInt()
                   index++
               }
           }
           ans.append('a'+now-1)
       }
        return ans.toString()
    }
}