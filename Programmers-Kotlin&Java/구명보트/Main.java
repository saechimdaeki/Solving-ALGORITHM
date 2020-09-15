package 프로그래머스.구명보트;

import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx=0;
        for(int i= people.length-1; idx<=i; i--){
            if(people[i]+ people[idx]<=limit) idx++;
            answer++;
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(new int[]{70,50,80,50},100));
        System.out.println(s.solution(new int[]{70,80,50},100));
        System.out.println(s.solution(new int[]{1,1,1,1},50));
    }
}
