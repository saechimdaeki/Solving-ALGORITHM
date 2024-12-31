package softeer.notool_택배마스터_광우;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n,m,k;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i =0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, new int[n]);
        System.out.println(answer);
    }

    static void dfs(int cnt , int[] result) {
        if (cnt == n) {
            answer = Math.min(answer, calculate(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cnt] = arr[i];
                dfs(cnt+1, result);
                visited[i] = false;
            }
        }
    }

    static int calculate(int[] result) {
        int sum = 0 ;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            int weight = 0;
            while( weight + result[idx] <=m) {
                weight +=result[idx];
                if (idx + 1 == n)
                    idx = 0;
                else
                    idx++;
            }
            sum += weight;
        }
        return sum;
    }
}
