package 코틀린.LeetCode.Two_Sum_IV

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val set = mutableSetOf<Int>()
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        return when {
            root == null -> false
            else -> dfs(root, k)
        }
    }
    fun dfs(node: TreeNode? , k: Int) : Boolean {
        return when {
            node == null -> false
            set.contains(k - node.`val`) -> true
            else -> {
                set.add(node.`val`)
                dfs(node.left, k) || dfs(node.right, k)
            }
        }
    }
}