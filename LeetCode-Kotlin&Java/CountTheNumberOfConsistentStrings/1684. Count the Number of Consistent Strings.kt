package CountTheNumberOfConsistentStrings

class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val map=HashMap<Char,Int>()
        for (c in allowed) {
            map[c] = 1
        }
        var cnt=0
       loop@for (word in words) {
            for (c in word) {
                if(!map.containsKey(c))
                    continue@loop
            }
            cnt++
        }
        return cnt
    }
}