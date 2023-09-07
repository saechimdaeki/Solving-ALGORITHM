package 코틀린.LeetCode.Most_Frequent_Subtree_Sum

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val map = mutableMapOf<Int, Int>()
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        dfs(root)
        val max = map.values.maxOrNull() ?: 0
        val list = mutableListOf<Int>()
        map.filter { it.value == max }.forEach{list.add(it.key)}
        return list.toIntArray()
    }

    fun dfs(root: TreeNode?) : Int {
        if (root == null) return 0
        val leftTraversal = dfs(root.left)
        val rightTraversal = dfs(root.right)
        val sum = leftTraversal + rightTraversal + root.`val`
        map[sum] = map[sum]?.let { it + 1 } ?: 1
        return sum
    }
}