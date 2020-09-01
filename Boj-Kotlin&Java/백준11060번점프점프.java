package 백준;

import java.util.*;

public class 백준11060번점프점프 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dp=new int[n];
        for(int i=0; i<n; i++)
            dp[i]=-1;
        for(int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        dp[0]=0;
        for(int i=0; i<n-1; i++){
            if(dp[i]==-1) continue;
            for(int j=1; j<=arr[i]; j++){
                if(i+j>=n) break;
                if(dp[i+j]==-1||dp[i+j]>dp[i]+1)
                    dp[i+j]=dp[i]+1;
            }
        }
        System.out.println(dp[n-1]);
    }
}
