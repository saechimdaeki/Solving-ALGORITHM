package LeetCode33

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var (left,right) = arrayOf(0,nums.size-1)
        while (left<= right) {
            val mid = left+ (right- left) / 2
            when (target) {
                nums[mid] -> return mid
                else -> when {
                    nums[left] <= nums[mid] -> {
                        when {
                            nums[mid] < target || nums[left] > target -> left = mid + 1
                            else -> right = mid - 1
                        }
                    }
                    else -> {
                        when {
                            nums[mid] > target || nums[right] < target -> right = mid - 1
                            else -> left = mid + 1
                        }
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val s= Solution()
    println(s.search(intArrayOf(4,5,6,7,0,1,2),0)) //4
    println(s.search(intArrayOf(4,5,6,7,0,1,2),3)) // -1
    println(s.search(intArrayOf(1),0)) // -1
}