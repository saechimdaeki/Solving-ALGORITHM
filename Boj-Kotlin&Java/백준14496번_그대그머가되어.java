package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 백준14496번_그대그머가되어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] ab= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nm= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr=new int[nm[0]+1][nm[0]+1];
        int[] dist=new int[nm[0]+1];
        Arrays.fill(dist,-1);
        for(int i=0; i<nm[1]; i++){
            int[] temp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[temp[0]][temp[1]]=arr[temp[1]][temp[0]]=1;
        }
        dist[ab[0]]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(ab[0]);
        while (!q.isEmpty()){
            int now=q.poll();
            if(now==ab[1]){
                System.out.println(dist[now]);
                System.exit(0);
            }
            for(int i=1; i<=nm[0]; i++){
                if(dist[i]==-1 && arr[now][i]==1){
                    dist[i]=dist[now]+1;
                    q.offer(i);
                }
            }
        }
        System.out.println(-1);
    }
}
