package 코틀린.LeetCode.Sum_Root_Leaf_Numbers

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val list = mutableListOf<String>()
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root, "")
        return list.sumOf { it.toInt() }
    }
    fun dfs(node: TreeNode?, num : String) {
        if (node == null) {
            return
        }

        val sum = num+node.`val`

        when {
            node.left == null && node.right == null -> {
                list.add(sum)
                return
            }
            else -> {
                dfs(node.left, sum)
                dfs(node.right, sum)
            }
        }
    }

}