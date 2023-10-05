package 자바.softeer.비밀_메뉴;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] secretButton = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            secretButton[i] = Integer.parseInt(st.nextToken());
        int[] userButton = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i< n; i++)
            userButton[i] = Integer.parseInt(st.nextToken());

        String secret = Arrays.stream(secretButton).mapToObj(String::valueOf).collect(Collectors.joining());
        String user = Arrays.stream(userButton).mapToObj(String::valueOf).collect(Collectors.joining());

        System.out.println(user.contains(secret) ? "secret" : "normal");
    }
}