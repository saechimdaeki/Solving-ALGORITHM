package 자바.pccp;

import java.util.LinkedList;

import java.util.Queue;

public class Solution03 {
    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0; // 현재 손님 수

        int orderIdx =0;

        int spendTime = -1;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < order.length * k ; i++) {
            if (k * orderIdx == i) {
                q.add(order[orderIdx++]);
            }

            if (spendTime == i) {
                q.poll();
                spendTime = -1;
            }

            if (spendTime == -1 && !q.isEmpty()) {
                spendTime = i+ menu[q.peek()];
            }
            answer = Math.max(answer, q.size());
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10)); // 3
        System.out.println(solution(new int[]{5, 12, 30}, new int[]{2, 1, 0, 0, 0, 1, 0}, 10)); // 4
        System.out.println(solution(new int[]{5}, new int[]{0, 0, 0, 0, 0}, 5)); // 1
    }
}
