package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj2109_순회강연 {
    static ArrayList<pair> arr=new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int temp=n;
        while (temp-->0){
            int[] tmp= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.add(new pair(tmp[0],tmp[1]));
        }
        Collections.sort(arr);
        int cnt=0;
        int ans=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i= 10000; i>=1; i--){
            if (cnt < n && arr.get(cnt).y == i) {
                do {
                    pq.offer(-arr.get(cnt).x);
                    cnt++;
                } while (cnt < n && arr.get(cnt).y == i);
            }
            if(!pq.isEmpty())
                ans+= (- pq.poll());
        }
        System.out.println(ans);
    }
}
class pair implements Comparable<pair>{
    int x;
    int y;
    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(pair o) {
        return o.y-this.y;
    }
}
