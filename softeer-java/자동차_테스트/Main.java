package 자바.softeer.자동차_테스트;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nq[0];
        int q = nq[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            int ans = 0;
            int input = Integer.parseInt(br.readLine());
            int search = search(input, arr);
            if (search >= 0)
                ans = search * (n - search - 1);
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    static int search(int input, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (input == arr[mid])
                return mid;
            else if (input > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}