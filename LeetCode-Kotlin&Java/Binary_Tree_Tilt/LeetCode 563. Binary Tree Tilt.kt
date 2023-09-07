package 코틀린.LeetCode.Binary_Tree_Tilt

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var answer = 0
    fun findTilt(root: TreeNode?): Int {
        dfs(root)
        return answer
    }

    fun dfs(node: TreeNode?): Int {
        return when (node) {
            null -> 0
            else -> {
                val left = dfs(node.left)
                val right = dfs(node.right)
                answer += abs(left - right)
                left + right + node.`val`
            }
        }
    }
}