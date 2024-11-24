package 나무_조경;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int answer = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int maxDepth = n == 2 ? 2 : 4;

        dfs(0, 0, maxDepth);

        System.out.println(answer);

    }

    private static void dfs(int depth, int sum, int maxDepth) {
        if (depth == maxDepth) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                for (int k = 0; k < 2; k++){
                    int nextx = i + dx[k];
                    int nexty = j + dy[k];
                    if (nextx<0 || nextx >= arr.length || nexty<0 || nexty >= arr.length || visited[nextx][nexty] ) continue;
                    visited[i][j] = true;
                    visited[nextx][nexty] = true;
                    dfs(depth+1, sum+arr[nextx][nexty] + arr[i][j], maxDepth);
                    visited[i][j] = false;
                    visited[nextx][nexty] = false;
                }
            }
        }
    }
}
