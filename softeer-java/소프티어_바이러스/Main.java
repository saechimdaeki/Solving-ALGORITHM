package softeer.바이러스;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int divide = 1000000007;

        Scanner sc = new Scanner(System.in);
        int k =sc.nextInt();
        int p = sc.nextInt();
        int n = sc.nextInt();

        long answer = k;

        for (int i =1; i<= n; i++) {
            answer = (answer*p) % divide;
        }
        System.out.println(answer);
        
    }
}