package LeetCode34

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var (left,right) = arrayOf(0, nums.size-1)
        while (left<=right){
            val mid = left + (right-left)/2
            if(nums[mid]==target){
                var ans1 = mid
              while1@ while (ans1>=0){
                    when (target) {
                        nums[ans1] -> ans1--
                        else -> break@while1
                    }
                }
                var ans2 = mid
              while2@ while (ans2<nums.size){
                  when (target) {
                      nums[ans2] -> ans2++
                      else -> break@while2
                  }
                }
                return intArrayOf(ans1+1,ans2-1)
            }
            when {
                target>nums[mid] -> left=mid+1
                else -> right=mid-1
            }
        }
        return intArrayOf(-1,-1)
    }
}

fun main() {
    val s = Solution()
    val s1 = s.searchRange(intArrayOf(5,7,7,8,8,10),8)
    s1.forEach { i ->
        print("$i ") //3 4
    }
    println()

    val s2 = s.searchRange(intArrayOf(5,7,7,8,8,10),6)
    s2.forEach { i->
        print("$i ") // -1 -1
    }
    println()

    val s3 = s.searchRange(intArrayOf(),0)
    s3.forEach { i->
        print("$i ") // -1 -1
    }

}





