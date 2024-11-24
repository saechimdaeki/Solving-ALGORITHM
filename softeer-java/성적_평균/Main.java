package 성적_평균;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        while (k-- > 0) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            int sum = prefixSum[to] - prefixSum[from - 1];

            double avg = Math.round((sum * 1.0 / (to - from + 1)) * 100) / 100.00;
            System.out.println(avg);
        }
    }
}
