package 백준;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class boj11123node{
    int x,y;

    public boj11123node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 백준11123번양한마리양두마리자바 {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int[][] arr;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] nm=br.readLine().split(" ");
            n=Integer.parseInt(nm[0]);
            m=Integer.parseInt(nm[1]);
            arr=new int[n][m];
            visited=new boolean[n][m];
            for(int i=0; i<n; i++)
            {
                String input=br.readLine();
                for(int j=0; j<input.length(); j++)
                {
                    if(input.charAt(j)=='#')
                        arr[i][j]=1;
                    else
                        arr[i][j]=0;
                }
            }
            int answer=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j]==1 && !visited[i][j]){
                        answer++;
                        bfs(i,j);
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
    }
    static void bfs(int x, int y){
        Queue<boj11123node> q=new LinkedList<>();
        visited[x][y]=true;
        q.offer(new boj11123node(x,y));
        while (!q.isEmpty()){
            boj11123node tmp=q.poll();
            int nowx=tmp.x;
            int nowy=tmp.y;
            for(int i=0; i<4; i++){
                int nx=nowx+dx[i];
                int ny=nowy+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m &&arr[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new boj11123node(nx,ny));
                }
            }
        }
    }
}
