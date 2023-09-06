package 코틀린.LeetCode.Average_of_Levels_in_Binary_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val list = mutableListOf<MutableList<Int>>()
        traversal(list, 0, root)
        val answer = mutableListOf<Double>()
        for (ints in list) {
            val sum = ints
                .asSequence()
                .map { it.toLong() }
                .sum()
            answer.add((sum.toDouble() / ints.size))
        }
        return answer.toDoubleArray()
    }

    fun traversal(list: MutableList<MutableList<Int>>, depth: Int, node: TreeNode?) {
        if (node == null)
            return

        if (list.size == depth)
            list.add(mutableListOf())

        list[depth].add(node.`val`)

        traversal(list, depth + 1, node.left)
        traversal(list, depth + 1, node.right)

    }
}