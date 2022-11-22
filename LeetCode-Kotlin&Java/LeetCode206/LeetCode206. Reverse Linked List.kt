package LeetCode206

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return head?.let { h ->
            h.next?.let {
                val new = reverseList(it)
                it.next = h
                head.next=null
                new
            } ?: head
        }
    }
}