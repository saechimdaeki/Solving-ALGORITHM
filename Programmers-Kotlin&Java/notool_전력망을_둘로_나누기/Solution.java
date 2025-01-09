package programmers.notool_전력망을_둘로_나누기;

import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        List<Integer>[] arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++)
            arr[i] = new ArrayList<>();
        
        for(int i = 0; i < wires.length; i++) {
            arr[wires[i][0]].add(wires[i][1]);
            arr[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            boolean[] visited = new boolean[n+1];
            arr[from].remove(Integer.valueOf(to));
            arr[to].remove(Integer.valueOf(from));
            int cnt = 1;
            Queue<Integer> q = new LinkedList<>();
            q.offer(from);
            while(!q.isEmpty()) {
                int now = q.poll();
                visited[now] = true;
                for(int j : arr[now]) {
                    if (!visited[j]) {
                        q.offer(j);
                        cnt++;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt- (n-cnt)));
            
            arr[from].add(to);
            arr[to].add(from);
        }
        
        return answer;
    }
}