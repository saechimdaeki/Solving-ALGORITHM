package 퍼즐게임챌린지;

class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        int max = 1, min = 100_000;
        while (max <= min) {
            int level = (min + max) / 2;
            long mid = calc(diffs, times, level);
            if (mid <= limit) {
                min = level - 1;
            } else
                max = level + 1;
        }
        return max;
    }

    private static long calc(int[] diffs, int[] times, int level) {
        long answer = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                answer += times[i];
            } else {
                answer += (long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,5,3}, new int[]{2,4,7},30)); // 3
        System.out.println(solution(new int[]{1,4,4,2}, new int[]{6,3,8,2},59)); // 2
        System.out.println(solution(new int[]{1,328,467,209,54}, new int[]{2,7,1,4,3},1723)); // 294
        System.out.println(solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001},3456789012L)); // 39354
    }
}