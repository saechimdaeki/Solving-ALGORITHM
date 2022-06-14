package LeetCode278

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var (left,right) = arrayOf(1,n)
        while (left<right){
            val mid = left+(right-left)/2
            when {
                !isBadVersion(mid) ->
                    left = mid+1
                else -> right = mid
            }
        }
        return left
    }
}

