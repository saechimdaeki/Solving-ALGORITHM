package LeetCode876

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * */

 class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        if(head!!.next==null)
            return head
        var (l,r)= arrayOf(head,head.next!!.next)
        while (l!=null && r?.next !=null){
           l=l.next
           r= r.next!!.next
        }
        return l?.next
    }
}