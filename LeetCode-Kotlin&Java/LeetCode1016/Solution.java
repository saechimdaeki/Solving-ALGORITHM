package 자바.LeetCode1016;

import java.util.stream.IntStream;

class Solution {
    public static boolean queryString(String s, int n) {
        return IntStream.rangeClosed(1, n).mapToObj(Integer::toBinaryString).allMatch(s::contains);
    }


    public static void main(String[] args) {
        System.out.println(queryString("0110", 3)); // true
        System.out.println(queryString("0110", 4)); // false
    }
}