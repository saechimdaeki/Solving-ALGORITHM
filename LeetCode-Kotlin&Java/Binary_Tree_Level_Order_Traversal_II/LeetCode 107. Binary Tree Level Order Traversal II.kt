package 코틀린.LeetCode.Binary_Tree_Level_Order_Traversal_II


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        traversal(list, root,0)
        return list
    }

    fun traversal(list: MutableList<MutableList<Int>>, node: TreeNode? , depth: Int) {
        if (node == null)
            return
        if (depth == list.size)
            list.add(0, mutableListOf())

        traversal(list, node.left, depth+1)
        traversal(list, node.right, depth+1)

        list[list.size - depth - 1].add(node.`val`)

    }
}