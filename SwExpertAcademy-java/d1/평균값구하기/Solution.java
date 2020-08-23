package d1.평균값구하기;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++)
        {
            int sum=0;
            String[] abcd=br.readLine().split(" ");
            for(int j=0; j< abcd.length; j++)
                sum+=Integer.parseInt(abcd[j]);

            bw.write("#"+i+" "+Math.round(sum/10.0)+"\n");
        }
        bw.flush();
    }
}
