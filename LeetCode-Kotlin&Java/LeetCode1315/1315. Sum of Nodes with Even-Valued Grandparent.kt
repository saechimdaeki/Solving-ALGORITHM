package LeetCode1315

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
    fun sumEvenGrandparent(root: TreeNode?): Int {
        dfs(root,null,null)
        return ans
    }
    fun dfs(now:TreeNode?,p:TreeNode?,gp:TreeNode?){
        if(now==null) return
        ans+=if(gp!=null && gp.`val`%2==0) now.`val` else 0
        dfs(now.left,now,p)
        dfs(now.right,now,p)
    }
}

