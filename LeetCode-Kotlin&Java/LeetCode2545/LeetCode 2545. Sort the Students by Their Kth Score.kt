package algorithm.LeetCode2545

import java.util.*

/*
Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]

Input: score = [[3,4],[5,6]], k = 0
Output: [[5,6],[3,4]]
 */
class Solution {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        score.sortBy { -it[k] }
        return score
    }
}
