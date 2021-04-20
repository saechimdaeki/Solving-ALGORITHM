package LeetCode1448

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var ans=0
    fun goodNodes(root: TreeNode?): Int {
        dfs(root,root!!.`val`)
        return ans
    }
    fun dfs(root:TreeNode?,value:Int){
        if(root==null) return
        if(value<=root.`val`) ans++
        dfs(root.left, maxOf(value,root.`val`))
        dfs(root.right, maxOf(value,root.`val`))
    }
}

/**
 *  without global variable
     *
 *  class Solution {
    fun goodNodes(root: TreeNode?): Int {
    return dfs(root,root!!.`val`)
    }
    fun dfs(root:TreeNode?,value:Int):Int{
    if(root==null) return 0
    var (ans,`val`)= arrayOf(0,value)
    if(root.`val`>=`val`){
    ans++
    `val`=root.`val`
    }
    val left=dfs(root.left,`val`)
    val right=dfs(root.right,`val`)
    return ans+left+right
    }
    }
 *
 *
 */
