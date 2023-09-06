package 코틀린.LeetCode.Minimum_Depth_of_Binary_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    val list = mutableListOf<Int>()
    fun minDepth(root: TreeNode?): Int {

        dfs(root, 1)

        return list.minOrNull() ?: 0
    }

    fun dfs(node:TreeNode?, depth: Int) {
        when (node) {
            null -> return
            else -> when {
                node.left == null && node.right == null -> list.add(depth)
                else -> {
                    dfs(node.left, depth + 1)
                    dfs(node.right, depth + 1)
                }
            }
        }
    }
}