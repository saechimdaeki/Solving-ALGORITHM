package programmers.notool_네트워크;

import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (!visited[i]){
                dfs(n,computers,i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int n, int[][] computers, int x) {
        if (visited[x]) return;
        visited[x] = true;
        for (int i = 0; i < n; i++) {
            if(computers[x][i] == 1 && !visited[i])
                dfs(n, computers,i);
        }
    }
    
}