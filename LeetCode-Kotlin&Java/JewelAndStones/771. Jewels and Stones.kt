package JewelAndStones

class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        var cnt=0
        stones.forEach { stone ->
            when {
                jewels.indexOf(stone)!=-1 -> cnt++
            }
        }
        return cnt
    }
}