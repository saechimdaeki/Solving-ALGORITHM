package LeetCode1502

import kotlin.math.abs

class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val chai = arr.sort().run { arr[1] - arr[0] }
        (0 until arr.size-1).forEach { i ->
            if(abs(arr[i+1]-arr[i])!=chai) return false
        }
        return true
    }
}
