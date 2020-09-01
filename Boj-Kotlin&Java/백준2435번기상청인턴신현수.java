package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준2435번기상청인턴신현수 {
    static int n,k;
    static int[] arr;
    static int max=Integer.MIN_VALUE;
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nk=br.readLine().split(" ");
        n=Integer.parseInt(nk[0]);
        k=Integer.parseInt(nk[1]);
        arr=new int[n];
        String[] input=br.readLine().split(" ");
        for(int i=0; i<input.length; i++)
            arr[i]=Integer.parseInt(input[i]);
        for(int i=0; i<=n-k; i++){
            for(int j=i; j<i+k; j++)
                sum+=arr[j];
            max=Math.max(max,sum);
            sum=0;
        }
        System.out.println(max);
    }
}
