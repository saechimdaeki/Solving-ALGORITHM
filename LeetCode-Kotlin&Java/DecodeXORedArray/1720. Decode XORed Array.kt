package DecodeXORedArray

class Solution {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val ans= arrayListOf<Int>()
        ans.add(first)
        var temp=first
        encoded.forEach { i ->
            val next=temp xor i
            ans.add(next)
            temp=next
        }
        return ans.toIntArray()
    }
}