package programmers.notool_숫자_게임;

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : A)
            pq.offer(i);
        Arrays.sort(B);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i : B)
            dq.add(i);
        
        while(!pq.isEmpty()) {
            int t = pq.poll();
            if (t < dq.peekLast()) {
                dq.pollLast();
                answer++;
            } else {
                dq.pollFirst();
            }
        }
        
        return answer;
    }
}