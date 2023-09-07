package 코틀린.LeetCode.Binary_Tree_Zigzag_Level_Order_Traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    val list = mutableListOf<MutableList<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        traversal(root, 0)
        return list
    }

    fun traversal(node: TreeNode?, depth: Int) {
        when (node) {
            null -> return
            else -> {
                when (depth) {
                    list.size -> list.add(mutableListOf())
                }
                when {
                    depth % 2 == 0 -> list[depth].add(node.`val`)
                    else -> list[depth].add(0, node.`val`)
                }
                traversal(node.left, depth + 1)
                traversal(node.right, depth + 1)
            }
        }
    }
}