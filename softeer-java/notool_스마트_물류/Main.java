package softeer.notool_스마트_물류;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] input = br.readLine().toCharArray();        
        int answer = 0 ;
        for(int i = 0 ; i < n; i ++) {
            if (input[i]=='P') {
               for (int j = i - k; j <= i + k; j++) {
                   if (j <0 || j >=n)
                       continue;
                   if (input[j] == 'H') {
                       input[j] = 'X';
                       answer++;
                       break;
                   }
               } 
            }
        }
        System.out.println(answer);
    }
}
