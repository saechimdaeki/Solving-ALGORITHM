package LeetCode116

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}


class Solution {
    fun connect(root: Node?): Node? {
        return root?.run {
            root.left?.apply {
                next = root.right
            }
            root.right?.apply {
                root.next?.also { b -> next = b.left }
            }
            connect(root.left)
            connect(root.right)
            root
        }
    }
}