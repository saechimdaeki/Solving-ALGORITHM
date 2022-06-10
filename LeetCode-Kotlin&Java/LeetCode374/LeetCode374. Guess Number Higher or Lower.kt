package LeetCode374

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var (left,right) = arrayOf(1,n)
        while(left<right){
            var mid = left+ (right-left)/2
            when {
                guess(mid)==0 -> return mid
                guess(mid)==1 -> left=mid+1
                else -> right=mid
            }
        }
        return left
    }
}