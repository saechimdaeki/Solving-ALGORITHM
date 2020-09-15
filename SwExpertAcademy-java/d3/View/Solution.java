package swexpertacademy.d3.View;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T;
            T=sc.nextInt();
            int answer=0;
            int[] arr=new int[T];
            for(int i=0; i<T; i++){
                arr[i]=sc.nextInt();
            }
            for(int i=2; i<T-2; i++){
                int[] all=new int[4];
                all[0]=arr[i]-arr[i-1];
                all[1]=arr[i]-arr[i-2];
                all[2]=arr[i]-arr[i+1];
                all[3]=arr[i]-arr[i+2];
                if(all[0]<0||all[1]<0||all[2]<0||all[3]<0) continue;
                else{
                    Arrays.sort(all);
                    answer+=all[0];
                }
            }
            bw.write("#"+test_case+" "+answer+"\n");
        }
        bw.flush();
    }
}