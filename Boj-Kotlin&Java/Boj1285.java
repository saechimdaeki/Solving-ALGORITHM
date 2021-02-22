import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] arr=new String[n];
        for(int i=0; i<n; i++)
            arr[i]=br.readLine();
        int answer=n*n;
        for(int i=0; i<(1<<n); i++){
            int sum=0;
            for(int j=0; j<n; j++){
                int cnt=0;
                for(int k=0; k<n; k++){
                    char now=arr[k].charAt(j);
                    if((i&(1<<k))!=0) now = flip(now);
                    if(now=='T')
                        cnt++;
                }
                sum+=Math.min(cnt,n-cnt);
            }
            answer=Math.min(answer,sum);
        }
        System.out.println(answer);
    }
    static char flip(char a){
        return a == 'H' ? 'T' : 'H';
    }
}

