package LeetCode617


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return root1?.let {
            root2?.let {
                TreeNode(root1.`val` + root2.`val`).apply {
                    this.left = mergeTrees(root1.left, root2.left)
                    this.right = mergeTrees(root1.right, root2.right)
                }
            } ?: root1
        } ?: root2
    }
}
