package LeetCode1347

class Solution {
    fun minSteps(s: String, t: String): Int {
        val smap= mutableMapOf<Char,Int>()
        var tmap= mutableMapOf<Char,Int>()
        var answer=0
        
        s.indices.forEach { i ->
            smap[s[i]]=smap.getOrDefault(s[i],0)+1
        }
        t.indices.forEach { i ->
            tmap[t[i]]=tmap.getOrDefault(t[i],0)+1
        }
        tmap.keys.forEach { key ->
            when {
                smap.containsKey(key) && tmap[key]!!>smap[key]!! -> answer+=(tmap[key]!!-smap[key]!!)
                !smap.containsKey(key) -> answer+=tmap[key]!!
            }
        }
        return answer
    }
}