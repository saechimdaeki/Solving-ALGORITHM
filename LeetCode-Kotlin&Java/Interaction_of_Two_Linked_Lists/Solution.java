package 자바.leetcode.Interaction_of_Two_Linked_Lists;


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp1 = headA, tmp2 = headB;

        while (tmp1!= null) {
            set.add(tmp1);
            tmp1 = tmp1.next;
        }

        while (tmp2 != null) {
            if (set.contains(tmp2)) return tmp2;
            tmp2 = tmp2.next;
        }
        return null;
    }
}