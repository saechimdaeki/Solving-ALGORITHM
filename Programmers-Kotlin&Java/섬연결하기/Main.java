package 프로그래머스.섬연결하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<pair> list=new ArrayList<>();
        parent=new int[n+1];
        for(int i=0; i<=n; i++)
            parent[i]=i;
        for(int i=0; i<costs.length; i++){
            list.add(new pair(costs[i][0],costs[i][1],costs[i][2]));
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            int from,to,cost;
            from=list.get(i).x;
            to=list.get(i).y;
            cost=list.get(i).cost;
            if(find(from)!=find(to)){
                answer+=cost;
                union(from,to);
            }
        }
        return answer;
    }
    public int find(int x){
        if(parent[x]==x)
            return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px>py)
            parent[px]=py;
        else
            parent[py]=px;
    }
}
class pair implements Comparable<pair> {
    int x,y,cost;
    public pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    @Override
    public int compareTo(pair o) {
        return this.cost-o.cost;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }
}
