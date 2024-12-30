package softeer.notool.장애물_인식_프로그램;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> answer = new ArrayList<>();
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++)
                arr[i][j] = s.charAt(j) - '0';
        }

        for(int i = 0 ; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]==1 && !visited[i][j]) {
                   Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i,j));
                    visited[i][j] = true;
                    int answerCnt = 1;
                    while(!q.isEmpty()) {
                        Pair pair = q.poll();
                        int nowx = pair.x;
                        int nowy = pair.y;
                        for (int k = 0; k <4; k++){
                            int nextx = nowx + dx[k];
                            int nexty = nowy + dy[k];
                            if (nextx<0 || nextx>=n || nexty<0 || nexty>=n || arr[nextx][nexty]!=1 || visited[nextx][nexty])
                                continue;
                            q.offer(new Pair(nextx,nexty));
                            visited[nextx][nexty]=true;
                            answerCnt++;

                        }
                    }
                    answer.add(answerCnt);
                }
            }
        }

        
        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) System.out.println(integer);
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
