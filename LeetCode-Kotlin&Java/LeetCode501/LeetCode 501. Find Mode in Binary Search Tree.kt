package 코틀린.LeetCode.LeetCode501

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    val map = mutableMapOf<Int, Int>()

    fun findMode(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf()
        dfs(root)
        map.values.max().let { max ->
            return map.filter { it.value == max }.keys.toIntArray()
        }
    }

    fun dfs(node: TreeNode?) {
        if (node == null) return
        map[node.`val`] = map.getOrDefault(node.`val`, 0) + 1
        dfs(node.left)
        dfs(node.right)
    }
}