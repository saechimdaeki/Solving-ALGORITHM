package 자바.boj.수열_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(arr, 0, k).sum();
        int answer = sum;
        for (int i=k; i<n; i++) {
            sum+=arr[i];
            sum-=arr[i-k];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
