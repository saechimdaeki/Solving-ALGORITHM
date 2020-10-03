package 프로그래머스.프렌즈4블록;

import java.util.Arrays;

class Solution {
    char[][] graph;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        graph=new char[m][n];
        for(int i=0; i<m; i++){
            graph[i]=board[i].toCharArray();
        }
        while (true) {
            int tmp=0;
            boolean[][] visited=new boolean[m][n] ;
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if(graph[i][j]==' ') continue;
                    check(visited,i,j);
                }
            }
            for(int i=0; i<m;i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]){
                      tmp++;
                      graph[i][j]=' ';
                    }
                }
            }
            if(tmp==0) break;
            answer+=tmp;
            for(int i=0; i<n; i++){
                for(int j=m-1; j>=0; j--){
                    if(graph[j][i]==' '){
                        for(int k=j-1; k>=0; k--){
                            if(graph[k][i]!=' '){
                                graph[j][i]=graph[k][i];
                                graph[k][i]=' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    public void check(boolean[][] visited,int i,int j){
        char now=graph[i][j];
        for(int k=i; k<i+2; k++){
            for(int l=j; l<j+2; l++){
                if(now!=graph[k][l]) return;
            }
        }
        for(int k=i; k<i+2; k++){
            for(int l=j; l<j+2; l++){
                visited[k][l]=true;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(4,5,new String[]{"CCBDE","AAADE","AAABF","CCBBF"}));
        System.out.println(s.solution(6,6,new String[]{"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"}));
    }
}
