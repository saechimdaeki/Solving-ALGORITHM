package 코틀린.LeetCode.LeetCode515


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val map = mutableMapOf<Int,Int>()
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        dfs(root, 0)
        return map.values.toList()
    }

    fun dfs(node: TreeNode?, level: Int) {
        if (node == null) return
        map[level] = maxOf(node.`val`, map[level] ?: Int.MIN_VALUE)
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
    }
}