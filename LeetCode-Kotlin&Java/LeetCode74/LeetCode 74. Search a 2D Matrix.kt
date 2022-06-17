package LeetCode74

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var (left,right) = arrayOf(0,matrix[0].size-1)
        while (left<matrix.size && right>=0){
            when {
                matrix[left][right] == target -> return true
                matrix[left][right]<target -> left++
                else -> right--
            }
        }
        return false
    }
}