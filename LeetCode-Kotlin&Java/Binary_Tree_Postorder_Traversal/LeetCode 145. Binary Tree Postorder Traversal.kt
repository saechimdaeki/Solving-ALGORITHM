package 코틀린.LeetCode.Binary_Tree_Postorder_Traversal


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        postOrder(root , list)
        return list
    }

    private fun postOrder(root:TreeNode?, list: MutableList<Int>) {
        if(root != null) {
            postOrder(root.left , list)
            postOrder(root.right , list)
            list.add(root.`val`)
        }
    }
}