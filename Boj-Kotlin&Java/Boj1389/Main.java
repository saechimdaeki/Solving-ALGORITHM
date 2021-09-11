package Boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 케빈 베이컨의 6단계 법칙 */
public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m= Integer.parseInt(s[1]);
        map=new int[n+1][n+1];
        int min= Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                map[i][j]=map[j][i]=min;
            }
        }

        while (m-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to]=1;
            map[to][from]=1;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j]>map[i][k]+map[k][j])
                        map[i][j]=map[i][k]+map[k][j];
                }
            }
        }


        int answer=-1;
        for(int i=1; i<=n; i++){
            int sum=0;
            for(int j=1; j<=n; j++)
                sum+=map[i][j];
            if(min>sum){
                min=sum;
                answer=i;
            }
        }
        System.out.println(answer);
    }
}