package 백준20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=nk[0],k=nk[1];
        int[] sooYul = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> map=new HashMap<>();
        int start=0,end=0,answer=0;
        while (start<n){
            if(map.getOrDefault(sooYul[start],0) !=k){
                map.put(sooYul[start], map.containsKey(sooYul[start]) ? map.get(sooYul[start])+1 : 1);
                start++;
            }else{
                map.put(sooYul[end],map.containsKey(sooYul[end]) ? map.get(sooYul[end])-1 : 1 );
                end++;
            }
            answer=Math.max(answer, start-end);
        }
        System.out.println(answer);
    }
}
