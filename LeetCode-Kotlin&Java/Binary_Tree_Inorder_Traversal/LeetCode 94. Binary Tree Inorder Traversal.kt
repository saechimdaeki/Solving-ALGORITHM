class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()

        inorder(root, list)
        return list
    }

    private fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            inorder(root.left, list)
            list.add(root.`val`)
            inorder(root.right, list)
        }
    }
}

