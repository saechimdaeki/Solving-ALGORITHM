package 나무_공격;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int attacker = 0;
        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    attacker++;
                }
                arr[i][j] = input;
            }
        }

        for (int i = 0; i < 2; i++) {
            int attackStartLine = sc.nextInt();
            int attackEndLine = sc.nextInt();
            for (int j = attackStartLine; j <= attackEndLine; j++) {
                for (int k = 1; k<=m; k++ ){
                    if (arr[j][k] == 1){
                        arr[j][k] = 0;
                        attacker--;
                        break;
                    }
                }
            }
        }
        System.out.println(attacker);
    }
}