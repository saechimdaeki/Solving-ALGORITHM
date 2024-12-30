package softeer.notool_Hanyang_Popularity_Exceeding_Competition;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String[] pc = br.readLine().split(" ");
            int p = Integer.parseInt(pc[0]);
            int c = Integer.parseInt(pc[1]);
            int friendly = Math.abs(p - answer);
            if (friendly <= c)
                answer++;
        }
        System.out.println(answer);
    }
}
