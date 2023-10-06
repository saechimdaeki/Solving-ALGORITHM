package 자바.softeer.gbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        List<Integer> realRoad = new ArrayList<>();
        List<Integer> testRoad = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            while (length-- > 0)
                realRoad.add(speed);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            while (length-- > 0)
                testRoad.add(speed);
        }
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(answer, testRoad.get(i) - realRoad.get(i));
        }
        System.out.println(answer);
    }
}