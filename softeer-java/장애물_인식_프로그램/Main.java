package 자바.softeer.장애물_인식_프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) grid[i][j] = input.charAt(j) - '0';
        }

        Queue<Point> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int answer = 0;
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Point now = q.poll();
                        int nowx = now.x;
                        int nowy = now.y;
                        answer++;
                        for (int k = 0; k < 4; k++) {
                            int nextx = nowx + dx[k];
                            int nexty = nowy + dy[k];
                            if (nextx<0 || nexty < 0 ||nextx>=n || nexty >= n || visited[nextx][nexty] || grid[nextx][nexty] == 0) continue;
                            q.offer(new Point(nextx, nexty));
                            visited[nextx][nexty]=true;
                        }
                    }
                    answerList.add(answer);
                }
            }
        }
        Collections.sort(answerList);
        System.out.println(answerList.size());
        answerList.forEach(System.out::println);

    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}