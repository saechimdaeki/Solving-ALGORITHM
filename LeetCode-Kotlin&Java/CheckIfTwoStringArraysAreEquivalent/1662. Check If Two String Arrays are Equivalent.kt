package CheckIfTwoStringArraysAreEquivalent

class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val ans1=StringBuffer()
        val ans2=StringBuffer()
        word1.forEach { s ->
            ans1.append(s)
        }
        word2.forEach { s->
            ans2.append(s)
        }
        return ans1.toString()==ans2.toString()
    }
}