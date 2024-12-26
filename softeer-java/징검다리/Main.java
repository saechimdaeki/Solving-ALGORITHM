package softeer.징검다리;

import java.io.*;
import java.util.*;

/**
 * input 5
 * 3 2 1 4 5
 * output
 * 3
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
