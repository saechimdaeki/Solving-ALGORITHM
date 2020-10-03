package 프로그래머스.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int now=routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][1]<now){
                now=routes[i][1];
            }
            if(routes[i][0]>now){
                answer++;
                now=routes[i][1];
            }
        }
        return answer+1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(new int[][]{{-20,15},{-14,-5},{-18,-13},{-5,-3}}));

    }
}
