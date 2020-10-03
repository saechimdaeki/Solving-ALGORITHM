package 프로그래머스.징검다리;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        long left=1,right=distance;
        Arrays.sort(rocks);
        while (left<=right){
            int past=0;
            int cnt=0;
            long mid=(left+right)/2;
            for(int i=0; i<rocks.length; i++){
                if (rocks[i] - past >= mid) past = rocks[i];
                else cnt++;
            }
            if(distance-past<mid) {
                cnt++;
            }
            if(cnt<=n){
                if(mid>answer)
                    answer=(int)mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(25,new int[]{2,14,11,21,17},2));
    }
}
