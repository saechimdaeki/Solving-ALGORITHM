package programmers.notool_게임_맵_최단거리;

import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(visited[i], -1);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            Pair now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i <4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx<0 || nx>=n || ny<0 ||ny>=m || visited[nx][ny] != -1 || maps[nx][ny] != 1) continue;
                visited[nx][ny] = visited[x][y] + 1;
                q.offer(new Pair(nx,ny));
            }
        }

        return visited[n-1][m-1];

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