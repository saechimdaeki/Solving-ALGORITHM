package 자바.leetcode.LeetCode1071;

class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        // str1을 str2로 나눠야함
        if(!(str1 + str2).equals(str2 + str1)) return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC")); // "ABC"
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // "AB"
        System.out.println(gcdOfStrings("LEET", "CODE")); // ""
    }
}