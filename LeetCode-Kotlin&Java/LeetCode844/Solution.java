package 자바.leetcode.LeetCode844;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();
            } else sStack.push(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            } else tStack.push(t.charAt(i));
        }
        return Objects.equals(sStack.toString(), tStack.toString());

    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##","c#d#")); // true
        System.out.println(backspaceCompare("a#c","b")); // false
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f")); // true
    }
}