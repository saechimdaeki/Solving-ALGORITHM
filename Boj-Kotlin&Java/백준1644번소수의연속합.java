package 백준;

import java.io.*;
import java.util.*;

public class 백준1644번소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[n+1];
        for(int i=2; i<=n; i++){
            if(!visited[i]){
                list.add(i);
                for(int j=i*2; j<=n; j+=i)
                    visited[j]=true;
            }
        }
        int left=0,right=0,answer=0;
        int sum=0;
        if(list.size()!=0)
            sum=list.get(0);
        while (left<=right &&right<list.size()){
            if(sum<=n){
                if(sum==n)
                    answer++;
                right++;
                if(right<list.size())
                    sum+= list.get(right);
            }else {
                sum -= list.get(left);
                left++;
            }
        }
        System.out.print(answer);
    }
}
