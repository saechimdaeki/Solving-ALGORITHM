package 자바.softeer.스마트_물류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int answer = 0 ;
        char[] pCharArray = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if ('P' == pCharArray[i]) { // 로봇이면
                for (int j = i - k; j <= i + k; j++) { // 로봇 -k부터 +k까지
                    if (j <0 || j >=n || i == j) continue;
                    if ('H' == pCharArray[j]) {
                        pCharArray[j] = ' '; // 체크했으니 지우고
                        answer ++ ;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}