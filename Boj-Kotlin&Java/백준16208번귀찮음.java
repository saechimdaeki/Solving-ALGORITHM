package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준16208번귀찮음 {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::valueOf)
                .toArray();
        long sum= Arrays.stream(arr).sum();
        long answer=0;
        for(int i=0; i<n; i++){
            sum-=arr[i];
            answer+=arr[i]*sum;
        }
        System.out.println(answer);
    }
}
