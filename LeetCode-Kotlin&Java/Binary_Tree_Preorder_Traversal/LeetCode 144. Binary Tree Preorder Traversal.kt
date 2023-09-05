package 코틀린.LeetCode.Binary_Tree_Preorder_Traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        preOrder(root , list)
        return list
    }

    private fun preOrder(node: TreeNode? , list:MutableList<Int>) {
        if(node != null) {
            list.add(node.`val`)
            preOrder(node.left , list)
            preOrder(node.right , list)
        }
    }
}