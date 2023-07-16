package 자바.pccp;

import java.util.LinkedList;
import java.util.Queue;

public class Solution04 {


    public static int solution(int n, int m, int[][] hole) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] board = new int[n][m];

        for (int[] h : hole) {
            board[h[0] - 1][h[1] - 1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 0});

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int used = curr[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny][used] && board[nx][ny] == 0) {
                        if (nx == n - 1 && ny == m - 1) {
                            return answer + 1;
                        }
                        visited[nx][ny][used] = true;
                        queue.add(new int[]{nx, ny, used});
                    }

                    if (used == 0) {
                        nx += dx[i];
                        ny += dy[i];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny][1] && board[nx][ny] == 0) {
                            if (nx == n - 1 && ny == m - 1) {
                                return answer + 1;
                            }
                            visited[nx][ny][1] = true;
                            queue.add(new int[]{nx, ny, 1});
                        }
                    }
                }
            }
            answer++;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(solution(4, 4, new int[][]{{2, 3}, {3, 3}})); // 5
        System.out.println(solution(5, 4, new int[][]{{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}})); // -1
    }
}
