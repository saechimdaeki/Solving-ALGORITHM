package 코틀린.programmers.n2배열_자르기;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[ (int) (right - left) + 1];

        for(int i= 0; left<=right; i++, left++) answer[i] = (int) Math.max(left / n, left % n) + 1;

        return answer;

    }

    public static void main(String[] args) {
        int[] solution1 = solution(3, 2, 5);
        System.out.println(Arrays.toString(solution1)); // [4,3,3,3,4,4,4,4]
        int[] solution2 = solution(4, 7, 14);
        System.out.println(Arrays.toString(solution2)); // [4,3,3,3,4,4,4,4]
    }
}
