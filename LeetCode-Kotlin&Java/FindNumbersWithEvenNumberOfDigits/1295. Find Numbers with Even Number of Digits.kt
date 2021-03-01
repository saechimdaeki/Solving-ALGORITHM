package FindNumbersWithEvenNumberOfDigits

class Solution {
    fun findNumbers(nums: IntArray): Int {
        var answer=0
        for (num in nums) {
            if(num.toString().length%2==0)
                answer++
        }
        return answer
    }
}