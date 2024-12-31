package softeer.notool_동계_테스트_시점_예측;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, visited;
    static int n,m,answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) 
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            int cnt = 0; 
            visited = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j]==1){
                        cnt++;
                        bfs();
                    }
                }
            }
            if (cnt == 0){
                break;
            }
            for (int i = 0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] >=2)
                        arr[i][j]=0;
                }
            }
            answer++;
        }

        

        
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            Pair now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n|| ny<0 || ny>=m) continue;
                if(arr[nx][ny] == 1) {
                    visited[nx][ny]++;
                } else if(arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.offer(new Pair(nx,ny));
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
