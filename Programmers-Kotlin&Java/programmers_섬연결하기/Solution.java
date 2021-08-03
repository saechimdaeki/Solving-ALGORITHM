package programmers_섬연결하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        AtomicInteger answer = new AtomicInteger();
        parent=new int[n+1];

        IntStream.rangeClosed(0, n).forEachOrdered(i -> parent[i] = i);

        ArrayList<pair> list = Arrays.stream(costs)
                .map(pairs -> new pair(pairs[0], pairs[1], pairs[2]))
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        BiFunction<Integer,Integer,Boolean> correct= (px,py)-> (find(px)!=find(py));

        list.stream().filter(pair ->correct.apply(pair.x,pair.y))
                .forEach(m-> {
                    answer.addAndGet(m.cost);
                    union(m.x,m.y);
                });

        return answer.get();
    }
    public int find(int x){
        return (parent[x]==x) ? x: (parent[x]=find(parent[x]));
    }
    public void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px>py) parent[px]=py; else parent[py]=px;
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
