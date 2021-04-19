package LeetCode1038

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}
class Solution {
    var ans=0
    fun bstToGst(root: TreeNode?): TreeNode? {
        if(root==null) return null
        bstToGst(root.right)
        ans+=root.`val`
        root.`val`=ans
        bstToGst(root.left)
        return root
    }
}