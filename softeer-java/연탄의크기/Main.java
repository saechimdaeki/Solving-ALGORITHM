package 연탄의크기;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] houses = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
        Arrays.sort(houses);

        int answer = 0;

        for (int i = 2; i <= 100; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (houses[j] % i == 0)
                    tmp++;
            }
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
