package RemoveDuplicatesfromSortedList




class ListNode(var `val`: Int) {
     var next: ListNode? = null
}
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head==null) return head
        if(head.next==null) return head
        var prev=head
        while (prev?.next !=null){
            prev.next?.also {
                when (it.`val`) {
                    prev?.`val` -> prev?.next=prev?.next?.next
                    else -> prev=prev?.next
                }
            }
        }
        return head
    }
}