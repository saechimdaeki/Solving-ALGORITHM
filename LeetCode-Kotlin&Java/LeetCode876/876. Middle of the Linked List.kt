package LeetCode876


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var (l, r) = arrayOf(head, head)
        while (r?.next != null) {
            l = l?.next
            r = r.next?.next
        }
        return l
    }
}