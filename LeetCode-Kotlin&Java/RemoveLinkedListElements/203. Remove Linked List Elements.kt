package 릿코드.RemoveLinkedListElements

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var heading=head  /// val 이녀석.....!
        var cur=heading
        var prev=ListNode(-1)
        prev.next=heading
        heading=prev
        while (cur!=null){
            when (cur.`val`) {
                `val` -> {
                    prev.next=cur.next
                }
                else -> {
                    prev=prev.next!!
                }
            }
            cur=cur.next
        }
        return heading.next
    }
}