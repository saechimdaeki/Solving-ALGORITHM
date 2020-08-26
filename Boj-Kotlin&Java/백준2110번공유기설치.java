package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준2110번공유기설치 {
    static int n,c;
    static long[] arr;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().split(" ");
        n=Integer.parseInt(nm[0]);
        c=Integer.parseInt(nm[1]);
        arr=new long[n];
        for(int i=0; i<n; i++)
            arr[i]=Long.parseLong(br.readLine());
        Arrays.sort(arr);
        long left=1,right=arr[n-1]-arr[0];
        while (left<=right){
            long mid=(left+right)/2;
            if(isok(mid)){
                answer=mid;
                left=mid+1;
            }else
                right=mid-1;
        }
        System.out.println(answer);
    }
    static boolean isok(long mid){
        int cnt=1;
        long tmp=arr[0];
        for(int i=0; i<n; i++)
        {
            if(arr[i]-tmp>=mid){
                cnt++;
                tmp=arr[i];
            }
        }
        return cnt>=c;
    }
}
