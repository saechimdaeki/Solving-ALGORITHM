package 자바.softeer.택배_마스터_광우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int n;
    static int m;
    static int k;

    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nmk[0];
        m = nmk[1];
        k = nmk[2];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[n];

        dfs(arr, 0, visited, new int[n]);

        System.out.println(answer);
    }

    static void dfs(int[] arr, int cnt, boolean[] visited, int[] temp) {
        if (cnt == n) {
            int idx = 0, bucket = 0, sum = 0;
            for (int i = 0; i < k; i++) {
                while (temp[idx] + bucket <= m) {
                    bucket += temp[idx];
                    idx = (idx + 1) % n;
                }
                sum += bucket;
                bucket = 0;
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[cnt] = arr[i];
                dfs(arr, cnt + 1, visited, temp);
                visited[i] = false;
            }
        }
    }
}