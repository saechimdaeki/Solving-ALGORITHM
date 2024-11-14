package HanyangPopularityExceedingCompetition;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int point = 0;
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            int abs = Math.abs(p - point);
            if (abs <= c) point++;
        }
        System.out.println(point);
    }
}
