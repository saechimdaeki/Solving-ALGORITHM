package algorithm.LeetCode2181

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeNodes(head: ListNode?): ListNode? {
        return head?.let {
            val tmp = ListNode(-1)
            var tail = tmp
            var now = it.next
            var sum = 0
            while (now != null) {
                when (now.`val`) {
                    0 -> {
                        tail.next = ListNode(sum)
                        tail = tail.next!!
                        sum = 0
                    }
                }
                sum += now.`val`
                now = now.next
            }
            tmp.next
        } ?: head
    }
}