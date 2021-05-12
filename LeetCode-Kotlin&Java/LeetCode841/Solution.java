package LeetCode841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/* 841. Keys and Rooms */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()){
            int now=q.poll();
            if(visited[now]) continue;
            visited[now]=true;
            for(int i: rooms.get(now)){
                if(!visited[i])
                    q.offer(i);
            }
        }
        for(int i=0; i< visited.length; i++)
            if(!visited[i]) return false;
        return true;
    }
}

//public class Solution {
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        boolean[] visited=new boolean[rooms.size()];
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(0);
//        while (!q.isEmpty()){
//            int now=q.poll();
//            if(visited[now]) continue;
//            visited[now]=true;
//            rooms.get(now).stream().mapToInt(i -> i).filter(i -> !visited[i]).forEachOrdered(q::offer);
//        }
//        return IntStream.range(0, visited.length).allMatch(i -> visited[i]);
//    }
//}
