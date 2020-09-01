package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준2143번두배열의합 {
    static  StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        int[] arr1=new int[n];
        for(int i=0; i<n; i++)
            arr1[i]=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        int[] arr2=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            arr2[i]=Integer.parseInt(st.nextToken());
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> second=new ArrayList<>();
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++)
            {
                sum+=arr1[j];
                first.add(sum);
            }
        }
        for(int i=0; i<m; i++){
            int sum=0;
            for(int j=i; j<m; j++){
                sum+=arr2[j];
                second.add(sum);
            }
        }
        long answer=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:second){
            if(map.containsKey(i)){
                int tmp=map.get(i);
                map.put(i,tmp+1);
            }else
                map.put(i,1);
        }
        for(int i:first){
            if(map.containsKey(t-i))
                answer+=map.get(t-i);
        }
        System.out.println(answer);
    }
}
