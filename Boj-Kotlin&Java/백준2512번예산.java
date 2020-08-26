package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준2512번예산 {
    static int n,m;
    static int[] arr;
    static int right=-1,left=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        String[] input=br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            right=Math.max(right,arr[i]);
        }
        m=Integer.parseInt(br.readLine());
        long answer=0,sum=0;
        while (left<=right){
            sum=0;
            int mid=(left+right)/2;
            for(int i=0; i<n; i++)
                sum+=Math.min(arr[i],mid);
            if(sum<=m){
                answer=mid;
                left=mid+1;
            }else
                right=mid-1;
        }
        System.out.println(answer);
    }
}
