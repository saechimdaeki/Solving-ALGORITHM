package 자바.leetcode.LeetCode434;

/* 434. Number of Segments in a String */
class Solution {
    public static int countSegments(String s) {
        if (s.isEmpty())
            return 0;

        boolean isEmptySpace = true;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if(isEmptySpace && s.charAt(i) == ' ') continue;
            if (s.charAt(i) == ' ') {
                isEmptySpace = true;
            }
            else  {
                if(isEmptySpace) answer++;
                isEmptySpace = false;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John")); // 5
        System.out.println(countSegments("Hello")); // 1
        System.out.println(countSegments(", , , ,        a, eaefa")); // 6
        System.out.println(countSegments("                ")); // 0
    }
}