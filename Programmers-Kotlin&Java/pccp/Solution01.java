package 자바.pccp;

import java.util.Arrays;

public class Solution01 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static int[] solution(String command) {
        int idx = 0;
        int sx = 0, sy = 0;
        for (int i = 0; i < command.length(); i++) {
            if ('R' == command.charAt(i)) {
                idx = (idx + 1) % 4;
            }
            else if ('L' == command.charAt(i)) {
                idx = (idx + 3) % 4;
            }
            else if ('G' == command.charAt(i)) {
                sx += dx[idx];
                sy += dy[idx];
            }

            else if ('B' == command.charAt(i)) {
                sx -= dx[idx];
                sy -= dy[idx];
            }
        }
        return new int[]{sx, sy};
    }

    public static void main(String[] args) {
        int[] grglgrgs = solution("GRGLGRG");
        System.out.println(Arrays.toString(grglgrgs)); // 2,2

        int[] grgrgrbs = solution("GRGRGRB");
        System.out.println(Arrays.toString(grgrgrbs)); // 2,0
    }
}
