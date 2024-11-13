package 전광판;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // 아예 꺼짐, 0 ~ 9
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 0}, // 0
                {0, 0, 1, 1, 0, 0, 0}, // 1
                {0, 1, 1, 0, 1, 1, 1}, // 2
                {0, 1, 1, 1, 1, 0, 1}, // 3
                {1, 0, 1, 1, 0, 0, 1}, // 4
                {1, 1, 0, 1, 1, 0, 1}, // 5
                {1, 1, 0, 1, 1, 1, 1}, // 6
                {1, 1, 1, 1, 0, 0, 0}, // 7
                {1, 1, 1, 1, 1, 1, 1}, // 8
                {1, 1, 1, 1, 1, 0, 1}, // 9
                {0, 0, 0, 0, 0, 0, 0}, // 꺼짐
        };

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String a = scanner.next();
            String b = scanner.next();
            int answer = 0;
            if (a.length() != b.length()) {
                String reverseA = new StringBuilder(a).reverse().toString();
                String reverseB = new StringBuilder(b).reverse().toString();
                int max = Math.max(a.length(), b.length());
                for (int i = 0; i < max; i++) {
                    int[] aChar = i >= a.length() ? arr[10] : arr[reverseA.charAt(i) - '0'];
                    int[] bChar = i >= b.length() ? arr[10] : arr[reverseB.charAt(i) - '0'];
                    answer += IntStream.range(0, aChar.length).map(j -> Math.abs(aChar[j] - bChar[j])).sum();
                }

            } else {
                for (int i = 0; i < a.length(); i++) {
                    int[] aChar = arr[a.charAt(i) - '0'];
                    int[] bChar = arr[b.charAt(i) - '0'];
                    answer += IntStream.range(0, aChar.length).map(j -> Math.abs(aChar[j] - bChar[j])).sum();
                }
            }
            System.out.println(answer);
        }
    }
}
