package 프로그래머스.순위;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph=new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
            Arrays.fill(graph[i], 1000000000);
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) graph[i][j]=0;
                else continue;
            }
        }
        for(int i=0; i<results.length; i++){
            graph[results[i][0]][results[i][1]]=1;
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][k]+graph[k][j]<graph[i][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            boolean check=false;
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(graph[i][j]==1000000000 && graph[j][i]==1000000000){
                    check=true;
                    break;
                }
            }
            if(!check) answer++;
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(5,new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
}
