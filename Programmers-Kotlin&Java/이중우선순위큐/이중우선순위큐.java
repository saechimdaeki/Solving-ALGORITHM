package 프로그래머스.이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

class SolutionHeap {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minq=new PriorityQueue<>();
        PriorityQueue<Integer> maxq=new PriorityQueue<>(Comparator.reverseOrder());
        for (String operation : operations) {
            String[] q = operation.split(" ");
            if (q[0].equals("I")) {
                minq.offer(Integer.parseInt(q[1]));
                maxq.offer(Integer.parseInt(q[1]));
            } else {
                if(!maxq.isEmpty()) {
                    int temp;
                    if (q[1].equals("1")) {
                        temp = maxq.peek();
                    } else {
                        temp = minq.peek();
                    }
                    maxq.remove(temp);
                    minq.remove(temp);
                }
            }
        }
        if(minq.isEmpty() ||maxq.isEmpty())
            return new int[]{0,0};
        else{
            return new int[]{maxq.poll(), minq.poll()};
        }
    }
}

public class 이중우선순위큐 {
    public static void main(String[] args) {
        SolutionHeap s=new SolutionHeap();
        int[] tmp=s.solution(new String[]{"I 16","D 1"});
    }
}
