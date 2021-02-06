import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class boj1644소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[n+1];
        IntStream.rangeClosed(2, n).filter(i -> !visited[i]).forEach(i -> {
            list.add(i);
            IntStream.iterate(i * 2, j -> j <= n, j -> j + i).forEachOrdered(j -> visited[j] = true);
        });
        int left=0,right=0,answer=0;
        int sum=0;
        if(list.size()!=0)
            sum=list.get(0);
        while (left<=right &&right<list.size()){
            if(sum<=n){
                if(sum==n)
                    answer++;
                right++;
                if(right<list.size())
                    sum+= list.get(right);
            }else {
                sum -= list.get(left);
                left++;
            }
        }
        System.out.print(answer);
    }
}