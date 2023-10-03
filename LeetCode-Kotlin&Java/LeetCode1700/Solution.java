package 자바.leetcode.LeetCode1700;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i< students.length; i++) {
            queue.add(students[i]);
            stack.add(sandwiches[sandwiches.length-i-1]);
        }

        int count = 0;
        do {
            if (stack.peek().equals(queue.peek())) {
                count = 0;
                stack.pop();
                queue.poll();
            } else {
                count++;
                queue.add(queue.poll());
            }

        } while (count != queue.size());
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1})); // 0
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1})); // 3
    }
}
