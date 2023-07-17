package 자바.LeetCode7;

class Solution {
    public static int reverse(int x) {

        String s = String.valueOf(x);
        boolean hasMinus = false;
        if (s.contains("-")) {
            hasMinus = true;
            s = s.replace("-", "");
        }

        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();

        if (Long.parseLong(reverse) > Integer.MAX_VALUE) {
            return 0;
        }

        return Integer.parseInt(hasMinus ? "-" + reverse : reverse);
    }

    public static void main(String[] args) {
        System.out.println(reverse(123)); // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120)); // 21
        System.out.println(reverse(0)); // 0
    }
}