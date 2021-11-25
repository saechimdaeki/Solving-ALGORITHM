package LeetCode2068

import kotlin.math.abs

class Solution {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val map= makeMap(word1)
        val map2= makeMap(word2)
        map.forEach { mutableEntry ->
            val key=mutableEntry.key
            val value=mutableEntry.value
            when {
                abs(map2.getOrDefault(key,0)-value)>3 -> return false
                else -> map2.remove(key)
            }
        }
        map2.forEach { mutableEntry ->
            when {
                mutableEntry.value>3 -> return false
            }
        }
        return true;
    }

    fun makeMap(word :String) :MutableMap<Char,Int>{
        val map= mutableMapOf<Char,Int>()
        word.forEach { c ->
            when {
                map.containsKey(c) -> map[c]= map[c]!! +1
                else -> map[c]=1
            }
        }
        return map
    }
}