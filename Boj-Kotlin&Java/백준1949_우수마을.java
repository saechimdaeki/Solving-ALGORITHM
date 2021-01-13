package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 백준1949_우수마을 {
    static int n;
    static ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    static int[] arr;
    static boolean[] visit;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        IntStream.rangeClosed(0, n).forEach(i -> lists.add(new ArrayList<>()));
        arr= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp=new int[n+1][2];
        visit=new boolean[n+1];
        int i=0;
        while (i<n-1) {
            int[] tmp= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            lists.get(tmp[0]).add(tmp[1]);
            lists.get(tmp[1]).add(tmp[0]);
            i++;
        }
        visit[1]=true;
        dfs(1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }
    static void dfs(int x){
        lists.get(x).stream().mapToInt(integer -> integer).filter(next -> !visit[next]).forEachOrdered(next -> {
            visit[next] = true;
            dfs(next);
            dp[x][0] += dp[next][1];
            dp[x][1] += Math.max(dp[next][0], dp[next][1]);
        });
        dp[x][0]+=arr[x-1];
    }
}
