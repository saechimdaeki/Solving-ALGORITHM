package LeetCode1047;

/* 1047. Remove All Adjacent Duplicates In String */

import java.util.Stack;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int idx=0;
        st.push(S.charAt(idx++));
        if (idx < S.length()) {
            do {
                char now = S.charAt(idx);
                if (!st.empty() && st.peek() == now) st.pop();
                else st.push(now);
                idx++;
            } while (idx < S.length());
        }
        while (!st.empty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
