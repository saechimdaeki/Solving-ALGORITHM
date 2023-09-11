package 자바.프로그래머스.연속_펄스_부분_수열의_합;


class Solution {
    public static long solution(int[] sequence) {
        int[] approach1 = new int[sequence.length];
        int[] approach2 = new int[sequence.length];

        for (int i = 0; i< sequence.length; i++) {
            if (i % 2 == 0) {
                approach1[i] = (sequence[i] * -1);
                approach2[i] = sequence[i];
            } else {
                approach1[i] = sequence[i];
                approach2[i] = (sequence[i] * -1);
            }
        }

        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];

        dp1[0] = approach1[0];
        dp2[0] = approach2[0];

        long answer = Math.max(dp1[0], dp2[0]);

        for (int i = 1; i <sequence.length; i++) {
            dp1[i] = Math.max(approach1[i], dp1[i-1] + approach1[i]);
            dp2[i] = Math.max(approach2[i], dp2[i-1] + approach2[i]);
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }


        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4})); // 10
    }
}