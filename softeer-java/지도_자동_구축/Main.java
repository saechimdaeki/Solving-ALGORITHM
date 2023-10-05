package 자바.softeer.지도_자동_구축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] dp = new double[n+1];
        dp[0] = 2;
        for (int i = 1; i <= n; i++)
            dp[i] = dp[i - 1] + Math.pow(2, i - 1);
        System.out.println((int)(dp[n] * dp [n]));
    }
}