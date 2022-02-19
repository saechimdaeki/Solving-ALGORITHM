package 백준2178;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] nm= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=nm[0],m=nm[1];
        int[][] grid=new int[n][m];
        int[][] cnt=new int[n][m];
        IntStream.range(0, n).forEachOrdered(i -> Arrays.fill(cnt[i], -1));
        {
            int i=0;
            while (i<n) {
                grid[i]= Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
                i++;
            }
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(0,0));
        cnt[0][0]=1;
        while (!queue.isEmpty()){
            Pair poll = queue.poll();
            int nowx=poll.x;
            int nowy= poll.y;;
            IntStream.range(0, 4).forEachOrdered(i -> {
                int nextx = nowx + dx[i], nexty = nowy + dy[i];
                if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) return;
                if (grid[nextx][nexty] != 0 && cnt[nextx][nexty] == -1) {
                    queue.offer(new Pair(nextx, nexty));
                    cnt[nextx][nexty] = cnt[nowx][nowy] + 1;
                }
            });
        }

        System.out.println(cnt[n-1][m-1]);
    }
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
