package XOROperationInAnArray

class Solution {
    fun xorOperation(n: Int, start: Int): Int {
        var answer=start
        (1 until n).forEach { i ->
            answer = answer xor (start+ 2 * i)
        }
        return answer
    }
}