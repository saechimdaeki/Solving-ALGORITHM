package MergeStringsAlternately

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val small= minOf(word1.length,word2.length)
        val big= maxOf(word1.length,word2.length)
        val ans=StringBuilder()
        (0 until small).forEach { i ->
            ans.append(word1[i])
            ans.append(word2[i])
        }
        (small until big).forEach { j ->
            when {
                word1.length>small -> ans.append(word1[j])
                else -> ans.append(word2[j])
            }
        }
        return ans.toString()
    }
}
// faster than 100.00% of Kotlin online submissions for Merge Strings Alternately. Saechimdaeki
