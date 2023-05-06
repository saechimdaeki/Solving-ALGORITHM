package 자바.요격시스템;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, ((o1, o2) -> o1[1] == o2[1] ?
                o1[0] - o2[0] : o1[1] - o2[1]));

        int tmp = -1;
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            if (s >= tmp) {
                answer++;
                tmp = e;
            }
        }

        return answer;
    }
}

