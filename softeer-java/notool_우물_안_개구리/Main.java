package softeer.notool_우물_안_개구리;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            list.get(from).add(to);
            list.get(to).add(from);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < list.get(i).size(); j++) {
                int friend = list.get(i).get(j);
                if (arr[i] <= arr[friend]){
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}
