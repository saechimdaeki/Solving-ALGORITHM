package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11048번이동하기 {
    static int n,m;
    static int[][] arr,dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().split(" ");
        n=Integer.parseInt(nm[0]);
        m=Integer.parseInt(nm[1]);
        arr=new int[n+1][m+1];
        dp=new int[n+1][m+1];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                arr[i+1][j+1]=Integer.parseInt(st.nextToken());
        }
        int tmp=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                tmp=Math.max(Math.max(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                dp[i][j]=tmp+arr[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
}
