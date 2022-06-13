package LeetCode744

/*  744. Find Smallest Letter Greater Than Target */
class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var (left,right) = arrayOf(0, letters.size-1)
        while (left<=right){
            val mid = left + (right-left)/2
            when {
                target>=letters[mid] -> left=mid+1
                else -> right=mid-1
            }
        }
        return letters[left % letters.size]
    }
}

fun main() {
    val s = Solution()
    println(s.nextGreatestLetter(charArrayOf('c','f','j'),'a')) // "c"
    println(s.nextGreatestLetter(charArrayOf('c','f','j'),'c')) // "f"
    println(s.nextGreatestLetter(charArrayOf('c','f','j'),'d')) // "f"
}
