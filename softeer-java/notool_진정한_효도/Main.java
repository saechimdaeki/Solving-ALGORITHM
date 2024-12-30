package softeer.notool_진정한_효도;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];

        for (int i = 0; i< 3; i ++) {
            for (int j= 0; j < 3; j++)
                arr[i][j] = sc.nextInt();
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0 ; i < 3; i++) {
            answer = Math.min(answer, getCost(arr[i][0],arr[i][1],arr[i][2]));
            answer = Math.min(answer,getCost(arr[0][i],arr[1][i],arr[2][i]));
        }
        System.out.println(answer);
                
    }

    static int getCost(int a, int b, int c) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i<=3; i++) {
            int cost = Math.abs(i-a) + Math.abs(i-b) + Math.abs(i-c);
            answer = Math.min(cost,answer);
        }
        return answer;
    }
}
