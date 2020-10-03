package 프로그래머스.가장먼노드;

import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    Integer[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited=new boolean[n+1];
        graph=new ArrayList[n+1];
        dist=new Integer[n+1];
        Arrays.fill(dist,-1);
        for(int i=0; i< n+1; i++)
            graph[i]=new ArrayList<Integer>();
        for(int i=0; i<edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        bfs(1);
        Arrays.sort(dist,Collections.reverseOrder());
        int tmp=dist[0];
        for(int i:dist){
            if(tmp==i)
                answer++;
        }
        return answer;
    }
    public void bfs(int x){
        visited[x]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(x);
        dist[x]=0;
        while (!q.isEmpty()){
          int now=q.poll();
          for(int i=0; i<graph[now].size(); i++){
              if(!visited[graph[now].get(i)]){
                  dist[graph[now].get(i)]=dist[now]+1;
                  visited[graph[now].get(i)]=true;
                  q.offer(graph[now].get(i));
              }
          }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(6,new int[][]{{3,6},{4,3}
        ,{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}
