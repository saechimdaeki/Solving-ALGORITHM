package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 백준10942번팰린드롬 {
    static int n;
    static int[] arr;
    static StringTokenizer st;
    static boolean[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        d=new boolean[n][n];
        for(int i=0; i<n; i++)
            arr[i]=Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++)
            d[i][i]=true;
        for(int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1])
                d[i][i+1]=true;
        }
        for (int k=2; k<n; k++) {
            for (int i=0; i<n-k; i++) {
                int j = i+k;
                if (arr[i] == arr[j] && d[i+1][j-1]) {
                    d[i][j] = true;
                }
            }
        }
        int m=Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++)
        {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(d[a-1][b-1])
                bw.write("1\n");
            else
                bw.write("0\n");
        }
        bw.flush();
    }
}
