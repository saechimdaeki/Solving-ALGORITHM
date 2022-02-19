package 백준16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] dist=new int[101];
        int[] grid=new int[101];
        Arrays.fill(dist,-1);
        for(int i=1; i<=100; i++) grid[i]=i;
        int[] nm= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=nm[0],m=nm[1];
        while (n+m -->0){
            int[] fromTO = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            grid[fromTO[0]]=fromTO[1];
        }
        Queue<Integer> q=new LinkedList<>();
        dist[1]=1;
        q.offer(1);
        while (!q.isEmpty()){
            int now=q.poll();
            IntStream.range(1, 7).map(i -> now + i).filter(next -> next <= 100)
                    .map(next -> grid[next]).filter(next -> dist[next] == -1)
                    .forEachOrdered(next -> {
                dist[next] = dist[now] + 1;
                q.offer(next);
            });
        }
        System.out.println(dist[100]-1);
    }
}
