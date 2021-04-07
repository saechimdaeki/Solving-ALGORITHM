package LeetCode1299

class Solution {
    fun replaceElements(arr: IntArray): IntArray {

        val ans= IntArray(arr.size)
        var max=-987654321

        (arr.size-1 downTo 0).forEach { i ->
            when (i) {
                arr.size-1 -> ans[i]=-1
                else -> {
                    when {
                        arr[i+1]>max -> max=arr[i+1]
                    }
                    ans[i]=max
                }
            }
        }
        return ans

    }
}