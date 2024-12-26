package softeer.택배_마스터_광우;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        dfs(0, new int[n]);
        System.out.println(answer);
    }

    static void dfs(int count, int[] result) {
        if (count == n) {
            answer = Math.min(answer, calculate(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[count] = arr[i];
                dfs(count + 1, result);
                visited[i] = false;
            }
        }
    }

    static int calculate(int[] result) {
        int total = 0;
        int index = 0;

        for (int i = 0; i < k; i++) {
            int weight = 0;
            while (weight + result[index] <= m) {
                weight += result[index];
                if (index + 1 == n)
                    index = 0;
                else
                    index++;
            }
            total += weight;
        }

        return total;
    }
}
