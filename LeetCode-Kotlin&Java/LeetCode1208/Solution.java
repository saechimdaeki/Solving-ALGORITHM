package 자바.leetcode.LeetCode1208;

class Solution {
    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int answer = 0;
        int now = 0;

        while (right < s.length()) {
            now += Math.abs(s.charAt(right) - t.charAt(right));
            while (now > maxCost) {
                now -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            answer = Math.max(answer, right- left + 1);
            right++;
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3)); // 3
        System.out.println(equalSubstring("abcd", "cdef", 3)); //1
        System.out.println(equalSubstring("abcd", "acde", 0)); // 1


    }
}