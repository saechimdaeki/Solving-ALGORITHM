package KidsWithTheGreatestNumberOfCandies

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val max=candies.max()!!
        val arr= arrayListOf<Boolean>()
        for (candy in candies) {
            when {
                candy>=max-extraCandies -> arr.add(true)
                else -> arr.add(false)
            }
        }
        return arr.toBooleanArray()
    }
}