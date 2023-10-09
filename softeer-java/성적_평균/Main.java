package 자바.softeer.성적_평균;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] sum = new double[n+1];
        IntStream.rangeClosed(1, n).forEachOrdered(i -> sum[i] = sum[i - 1] + arr[i - 1]);
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            double rangeSum = sum[end] - sum[start - 1];
            double rangeAverage = rangeSum / (double) (end - start + 1);
            bw.write(String.format("%.2f",rangeAverage)+"\n");

        }
        bw.flush();
    }
}