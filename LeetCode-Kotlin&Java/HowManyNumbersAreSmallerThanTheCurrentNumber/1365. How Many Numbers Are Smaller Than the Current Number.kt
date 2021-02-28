package HowManyNumbersAreSmallerThanTheCurrentNumber

class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val answer= arrayListOf<Int>()
        for (num in nums) {
            var cnt=0
            for (j in nums) {
                if(num>j)
                    cnt++
            }
            answer.add(cnt)
        }
        return answer.toIntArray()
    }
}