package 지도자동구축;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 2;

        for (int i = 1; i <= n; i++)
            answer = answer + (answer - 1);
        System.out.println(answer * answer);
    }
}
