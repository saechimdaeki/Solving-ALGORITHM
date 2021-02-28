package NumberOfStepsToReduceANumberToZero

class Solution {
    fun numberOfSteps (num: Int): Int {
        var cnt=0
        var temp=num
        while (temp!=0) {
            when {
                temp % 2 == 0 -> {
                    temp /= 2

                }
                else -> {
                    temp--
                }
            }
            cnt++
        }
        return cnt
    }
}