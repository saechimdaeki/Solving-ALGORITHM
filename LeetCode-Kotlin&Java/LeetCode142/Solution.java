package LeetCode142;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if(set.contains(head)) return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
}
