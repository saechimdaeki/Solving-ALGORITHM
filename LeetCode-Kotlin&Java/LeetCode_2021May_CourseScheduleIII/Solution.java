package LeetCode_2021May_CourseScheduleIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int sum=0;
        for (int[] cours : courses) {
            sum+=cours[0];
            pq.offer(-cours[0]);
            if(sum>cours[1]) {
                if(pq.size()==0) break;
                sum += pq.poll();
            }
        }
        return pq.size();
    }
}
