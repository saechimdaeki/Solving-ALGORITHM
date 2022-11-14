package LeetCode19

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var (l,r) = arrayOf(head,head)
        (0 until n).forEach { _ ->
            l = l!!.next
        }
        if (l == null) return head!!.next
        while (l?.next != null) {
            l = l?.next
            r = r?.next
        }
        r!!.next = r.next!!.next
        return head
    }
}