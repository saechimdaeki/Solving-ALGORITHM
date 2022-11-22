package LeetCode21


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return list1?.let {l1 ->
            list2?.let {
                l2 ->
                when {
                    l1.`val` < l2.`val` -> {
                        l1.next = mergeTwoLists(l1.next, l2)
                        l1
                    }
                    else -> {
                        l2.next = mergeTwoLists(l1,l2.next)
                        l2
                    }
                }
            } ?: l1
        } ?: list2
    }
}