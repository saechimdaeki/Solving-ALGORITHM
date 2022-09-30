package LeetCode226_kotlin

var ti = TreeNode(5)
var v = ti.`val`

//  Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        return when (root) {
            null -> null
            else -> TreeNode(root.`val`).apply {
                this.left = invertTree(root.right)
                this.right = invertTree(root.left)
            }
        }
    }

}

