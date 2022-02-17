package 백준2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 백준 2003번 수들의 합 2 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=nm[0],m=nm[1];
        int[] sooYul = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum=0,answer=0,start=0,end=0;
        while (true){
            if (sum >= m) sum -= sooYul[start++];
            else if(end==n) break;
            else sum -= -sooYul[end++];
            if(sum==m) answer++;
        }
        System.out.println(answer);
    }
}
