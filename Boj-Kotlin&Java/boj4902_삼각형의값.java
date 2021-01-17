import java.io.*;
import java.util.StringTokenizer;

public class boj4902_삼각형의값 {
    static int[][] arr;
    static int[][] srr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; ; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            if(t==0){
                bw.flush();
                System.exit(0);
            }
            arr=new int[t+1][(t+1)*2];
            srr=new int[t+1][(t+1)*2];
            answer= -100001;
            {
                int j=1;
                while (j<=t) {
                    int k=1;
                    while (k<=2*j-1) {
                        arr[j][k]=Integer.parseInt(st.nextToken());
                        srr[j][k]=srr[j][k-1]+arr[j][k];
                        k++;
                    }
                    j++;
                }
            }
            int j=1;
            while (j<=t) {
                int k=1;
                while (k<=2*j-1) {
                    func(0,j,k,k,t);
                    k++;
                }
                j++;
            }
            bw.write(i+". "+answer+"\n");
        }
    }
    static void func(int sum, int j, int l , int r,int n){
        if(j<1 || j>n || l<1 || r>2*j-1) return;
        sum+=srr[j][r]-srr[j][l-1];
        answer=Math.max(answer,sum);
        switch (l % 2) {
            case 0:
                func(sum, j - 1, l - 2, r, n);
                break;
            default:
                func(sum, j + 1, l, r + 2, n);
                break;
        }
    }
}
