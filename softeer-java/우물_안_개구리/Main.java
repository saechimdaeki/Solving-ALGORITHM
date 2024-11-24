package 우물_안_개구리;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<List<Integer>> list = IntStream.rangeClosed(0, n).<List<Integer>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());

        for (int i = 0; i < m; i++) {
            int from  = scanner.nextInt();
            int to = scanner.nextInt();
            list.get(from).add(to);
            list.get(to).add(from);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 0; j< list.get(i).size(); j++) {
                int friend = list.get(i).get(j);
                if (arr[i] <= arr[friend]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}
