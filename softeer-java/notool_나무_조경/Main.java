package softeer.notool_나무_조경;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int n, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());        
            }
        }

        int max = n==2 ? 2: 4;

        dfs(0, 0, max);
        System.out.println(answer);
    }

    static void dfs(int depth, int sum, int max) {

        if(depth == max) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                for (int k = 0; k <4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx<0 || nx>=n || ny <0 || ny>=n || visited[nx][ny]) continue;
                    visited[i][j] = true;
                    visited[nx][ny] = true;
                    dfs(depth +1 , sum + arr[nx][ny] + arr[i][j] , max);
                    visited[i][j] = false;
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
