package 함께하는효도;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] arr, point;
    static int n, m, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        point = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            point[i] = new int[]{startX, startY};
            answer += arr[startX][startY];
            visited[startX][startY] = true;
        }

        dfs(point[0][0], point[0][1], 0, 0, answer);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int friend, int time, int sum) {
        answer = Math.max(answer, sum);
        if (time == 3) {
            if (friend + 1 < m) {
                dfs(point[friend + 1][0], point[friend + 1][1], friend + 1, 0, sum);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nextx = x + dx[i];
                int nexty = y + dy[i];
                if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= n || visited[nextx][nexty]) continue;
                visited[nextx][nexty] = true;
                dfs(nextx, nexty, friend, time + 1, sum + arr[nextx][nexty]);
                visited[nextx][nexty] = false;
            }
        }
    }
}
