package ShuffleString

class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        val arr= arrayListOf<Pair<Char,Int>>()
        s.indices.mapTo(arr) { Pair(s[it],indices[it]) }
        arr.sortBy { it.second }
        val ans= arr.map { it.first }
        val answer=StringBuilder()
        ans.forEach { an ->
            answer.append(an)
        }
        return answer.toString()
    }
}