package FindTheHighestAltitude

class Solution {
    fun largestAltitude(gain: IntArray): Int {
        val ans= arrayListOf<Int>()
        ans.add(0)
        var now=0
        for (i in gain) {
            ans.add(now+i)
            now+=i
        }
        return ans.max()!!
    }
}