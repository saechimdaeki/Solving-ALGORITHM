import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//java 11
public class 백준1315번_RPG {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        var a=new int[1001][1001];
        var dp=new boolean[1001][1001];
        quest[] arr=new quest[n];
        for(int i=0; i<n; i++){
            arr[i]=new quest(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        var answer=0;
        for(int i=1; i<=1000; i++){
            for(int j=1; j<=1000; j++){
                var cnt=0;
                a[i][j]=2-i-j;
                for(int k=0; k<n; k++){
                    if(arr[k].STR<=i || arr[k].INT<=j){
                        a[i][j]+=arr[k].POINT;
                        cnt++;
                    }
                }
                if(i==1 && j==1)
                    dp[i][j]=true;
                else if(i>1 && dp[i-1][j]&&a[i-1][j]>0)
                    dp[i][j]=true;
                else if(j>1 && dp[i][j-1] && a[i][j-1]>0)
                    dp[i][j]=true;
                if(dp[i][j])
                    answer=Math.max(answer,cnt);
            }
        }
        System.out.println(answer);
    }
}

class quest{
    int STR;
    int INT;
    int POINT;

    public quest(int[] arr) {
        this.STR=arr[0];
        this.INT=arr[1];
        this.POINT=arr[2];
    }
}
