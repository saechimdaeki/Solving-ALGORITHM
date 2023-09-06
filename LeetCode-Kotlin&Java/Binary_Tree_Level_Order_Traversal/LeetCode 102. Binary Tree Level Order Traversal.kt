package 코틀린.LeetCode.Binary_Tree_Level_Order_Traversal


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        traversal(root, 0, list)

        return list
    }

    fun traversal(node: TreeNode?, level: Int, list: MutableList<MutableList<Int>>) {
        if (node == null) return

        if (level == list.size)
           list.add(mutableListOf())

        list[level].add(node.`val`)

        traversal(node.left, level + 1, list)
        traversal(node.right, level + 1, list)
    }

}