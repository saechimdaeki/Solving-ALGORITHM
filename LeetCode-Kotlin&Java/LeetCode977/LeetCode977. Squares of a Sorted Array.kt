package LeetCode977

/**
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
       return nums.map { it * it }.sorted().toIntArray()
    }
}