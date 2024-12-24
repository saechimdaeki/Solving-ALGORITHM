package softeer.cpti;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] cpti = new int[n];
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cpti[i] = Integer.parseInt(br.readLine(), 2);
            frequency.put(cpti[i], frequency.getOrDefault(cpti[i], 0) + 1);
        }

        int friendlyPairs = 0;

        for (int i = 0; i < n; i++) {
            int current = cpti[i];
            frequency.put(current, frequency.get(current) - 1);

            for (int b1 = 0; b1 < m; b1++) {
                int diff1 = current ^ (1 << b1);
                friendlyPairs += frequency.getOrDefault(diff1, 0);

                for (int b2 = b1 + 1; b2 < m; b2++) {
                    int diff2 = diff1 ^ (1 << b2);
                    friendlyPairs += frequency.getOrDefault(diff2, 0);
                }
            }
        }

        System.out.println(friendlyPairs);
    }
}