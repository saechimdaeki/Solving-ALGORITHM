package BOJ2660;

import java.io.*;
import java.util.StringTokenizer;

/* 회장뽑기 */
public class Main {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int inf=987654321;
        int n=Integer.parseInt(st.nextToken());
        map=new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                map[i][j]=inf;
            }
        }
        while (true){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(from==-1 && to ==-1) break;
            map[from][to]=map[to][from]=1;
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j] > map[i][k]+map[k][j])
                        map[i][j]=map[i][k]+map[k][j];
                }
            }
        }

        int max=inf;
        int[] scoreArr=new int[n+1];

        for(int i=1; i<=n; i++){
            int sc=0;
            for(int j=1; j<=n; j++){
                if(map[i][j]!=inf)
                    sc=Math.max(sc,map[i][j]);
            }
            scoreArr[i]=sc;
            max=Math.min(sc,max);
        }
        StringBuilder sb=new StringBuilder();
        bw.write(max+" ");
        int count=0;
        for(int i=1; i<=n; i++){
            if(max==scoreArr[i]){
                count++;
                sb.append(i).append(" ");
            }
        }
        bw.write(count+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
