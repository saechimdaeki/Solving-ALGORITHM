package 백준;

import java.io.*;

public class 백준9095번123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp=new int[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4; i<11; i++)
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        int t=Integer.parseInt(br.readLine());
        while (t-->0){
            bw.write(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        bw.flush();
    }
}
