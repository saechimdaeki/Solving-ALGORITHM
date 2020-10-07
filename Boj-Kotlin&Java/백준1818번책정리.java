package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준1818번책정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        int[] dp=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int idx=0;
        int answer=0;
        dp[0]=arr[0];
        for(int i=1; i<n; i++){
            if(dp[idx]<arr[i]){
                dp[++idx]=arr[i];
            }else{
                int loc=lower_bound(dp,arr[i],idx);
                dp[loc]=arr[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
    static int lower_bound(int[] array,int key, int idx){
        int left=0,right=idx;
        while (left<right){
            int mid=(left+right)/2;
            if(array[mid]<key){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
