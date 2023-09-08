package 코틀린.LeetCode.Swap_Nodes_In_Pairs

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        return swap(head)
    }

    fun swap(node: ListNode?) : ListNode? {
        if (node == null || node.next == null)
            return node
        val next = node.next
        node.next = swap(node.next!!.next)
        next!!.next = node
        return next
    }
}


