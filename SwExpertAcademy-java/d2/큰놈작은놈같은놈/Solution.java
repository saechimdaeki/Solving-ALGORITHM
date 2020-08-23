package d2.큰놈작은놈같은놈;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a<b)
                bw.write("#"+i+" "+"<\n");
            else if(a>b)
                bw.write("#"+i+" "+">\n");
            else
                bw.write("#"+i+" "+"=\n");
        }
        bw.flush();
    }
}
