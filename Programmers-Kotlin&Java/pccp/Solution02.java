package 자바.pccp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution02 {
    public static int solution(int[] ability, int number) {


        PriorityQueue<Integer> answer = Arrays.stream(ability).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        for(int i=0 ; i< number; i++) {
            Integer a1 = answer.poll();
            Integer a2 = answer.poll();
            answer.add(a1+a2);
            answer.add(a1+a2);
        }

        int sum = 0;
        while(!answer.isEmpty()) {
            sum += answer.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 3, 7, 2}, 2)); // 37
        System.out.println(solution(new int[]{1, 2, 3, 4}, 3)); // 26
    }
}
