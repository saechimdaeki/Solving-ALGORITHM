package LeetCode1302

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
    var answer=0
    var max=0
    fun deepestLeavesSum(root: TreeNode?): Int {
        if(root==null) return answer
        dfs(root,0)
        return answer
    }
    fun dfs(root:TreeNode?, depth:Int){
        if(root==null) return
        if(depth==max && root.left==null && root.right==null){
            answer+=root.`val`
            return
        }
        if(max<depth){
            max=depth
            answer=root.`val`
        }
        dfs(root.left,depth+1)
        dfs(root.right,depth+1)
    }
}
