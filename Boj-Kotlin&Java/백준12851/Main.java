package 백준12851;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] nk= Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n=nk[0],k=nk[1];
        int[] grid=new int[100001];
        int[] dist=new int[100001];
        boolean[] visited=new boolean[100001];
        Queue<Integer> q=new LinkedList<>();
        q.offer(n);
        dist[n]=0;
        grid[n]=1;
        visited[n]=true;
        while (!q.isEmpty()){
            int now=q.poll();
            int[] nextArray={now-1,now+1,now*2};
            for (int next : nextArray) {
                if(next<0 || next>100000) continue;
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                        dist[next] = dist[now] + 1;
                        grid[next] = grid[now];
                    } else if (dist[next] == dist[now] + 1)
                        grid[next] += grid[now];

            }
        }

        System.out.println(dist[k]);
        System.out.println(grid[k]);
    }

}


