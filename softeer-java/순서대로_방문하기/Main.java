package 자바.softeer.순서대로_방문하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] grid;
    static boolean[][] visited;

    static int count = 0;
    static List<Point> points = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            points.add(new Point(h, w));
        }
        dfs(points.get(0), 1, n, m);
        System.out.println(count);
    }

    static void dfs(Point point, int index, int n, int m) {
        if (point.x == points.get(index).x && point.y == points.get(index).y) {
            if (index == m - 1) {
                count++;
                return;
            }
            index++;
        }

        int nowx = point.x;
        int nowy = point.y;

        visited[nowx][nowy] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = nowx + dx[i];
            int nexty = nowy + dy[i];

            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= n || visited[nextx][nexty] || grid[nextx][nexty] == 1 )
                continue;

            dfs(new Point(nextx, nexty), index, n, m);
        }
        visited[nowx][nowy] = false;
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