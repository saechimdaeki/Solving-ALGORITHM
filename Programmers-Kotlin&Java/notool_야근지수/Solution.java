package programmers.notool_야근지수;

import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        for (int i = 0 ; i < works.length; i++)
            q.offer(works[i]);
        while (n > 0) {
            int work = q.poll();
            if (work == 0) break;
            work -=1;
            q.offer(work);
            n-=1;
        }
        
        while(!q.isEmpty()) {
            int work = q.poll();
            answer += work * work;
        }
        
        return answer;
    }
}