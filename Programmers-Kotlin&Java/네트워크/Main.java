package 프로그래머스.네트워크;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[] visited;
    int[][] graph;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        graph=new int[n][n];
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j]==1){
                    graph[i][j]=1;
                    graph[j][i]=1;
                }
            }
        }
        for(int i=0; i< graph.length; i++){
            for(int j=0; j< graph[i].length; j++){
                if(graph[i][j]==1 && !visited[i]){
                    bfs(i,n);
                    answer++;
                }
            }
        }
        return answer;
    }
    public void bfs(int x,int n){
        visited[x]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()){
            int now=q.poll();
            for(int i=0; i<n; i++){
                if(!visited[i] && graph[now][i]==1 ){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(s.solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }
}
