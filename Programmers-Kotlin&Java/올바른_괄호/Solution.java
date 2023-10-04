package 자바.프로그래머스.올바른_괄호;

import java.util.Stack;

class Solution {
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            answer = false;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()")); // true
        System.out.println(solution("(())()")); // true
        System.out.println(solution(")()(")); // false
        System.out.println(solution("(()(")); // false
    }
}
