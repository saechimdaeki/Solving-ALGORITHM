package 백준;

import java.io.*;

public class boj11502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        boolean[] arr=new boolean[1001];
        for(int i=2; i<=1000; i++){
            if(arr[i]) continue;
            for(int j=i+i; j<=1000; j+=i){
                arr[j]=true;
            }
        }
         loop: while (t-->0){
            int temp=Integer.parseInt(br.readLine());
            for(int i=2; i<=temp; i++){
                for(int j=2; j<=temp; j++){
                    for(int k=2; k<=temp; k++){
                        if(arr[i]||arr[j]||arr[k]) continue;
                        if((i+k+j)==temp){
                            System.out.println(i+" "+j+" "+k);
                            continue loop;
                        }
                    }
                }
            }
        }
    }
}
