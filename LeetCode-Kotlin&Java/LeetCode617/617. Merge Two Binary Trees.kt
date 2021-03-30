package LeetCode617

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */

class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
}

class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        when {
            root1==null && root2!=null -> return root2
            root1!=null && root2==null -> return root1
            root1==null && root2==null -> return null
        }
        val tree=TreeNode(root1!!.`val`+root2!!.`val`)
        tree.left=mergeTrees(root1.left,root2.left)
        tree.right=mergeTrees(root1.right,root2.right)
        return tree
    }
}

