package 자바.softeer.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;


public class Main {
    public static void main(String args[]) throws IOException {
        int div = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] kpn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = kpn[0];
        int p = kpn[1];
        int n = kpn[2];

        long[] dp = new long[n + 1];
        dp[0] = k;
        IntStream.rangeClosed(1, n).forEachOrdered(i -> dp[i] = (dp[i - 1] * p) % div);
        System.out.println(dp[n]);
    }
}