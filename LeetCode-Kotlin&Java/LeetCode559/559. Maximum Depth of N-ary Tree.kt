package LeetCode559

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Node(var `val`:Int){
    var children:List<Node?> = listOf()
}

class Solution {
    fun maxDepth(root: Node?): Int {
        if(root==null) return 0
        return dfs(root,1)
    }
    fun dfs(node:Node, depth:Int):Int{
        if(node.children.isEmpty())
            return depth
        var max=depth
        node.children.indices.forEach { i ->
            max= maxOf(max,dfs(node.children[i]!!,depth+1))
        }
        return max
    }
}