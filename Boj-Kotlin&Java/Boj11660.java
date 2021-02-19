import java.io.*;
import java.util.Arrays;

public class Boj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nm= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr =new int[nm[0]][nm[0]];
        for(int i=0; i<nm[0]; i++){
            int[] input= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(input, 0, arr[i], 0, input.length);
        }
        int[][] sum =new int[nm[0]+1][nm[0]+1];
        for(int i=1; i<=nm[0]; i++){
            for(int j=1; j<=nm[0]; j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i-1][j-1];
            }
        }
        for(int i=0; i<nm[1]; i++){
            int[] abcd= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(sum[abcd[2]][abcd[3]]-sum[abcd[0]-1][abcd[3]]-sum[abcd[2]][abcd[1]-1]+sum[abcd[0]-1][abcd[1]-1]+"\n");
        }
        bw.flush();
    }
}
