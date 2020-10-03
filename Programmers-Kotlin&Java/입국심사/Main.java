package 프로그래머스.입국심사;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left=0,right=0;
        for(int i:times){
            if(right<i)
                right=i;
        }
        right*=n;
        while (left<=right){
            long finishTime=0;
            long mid=(left+right)/2;
            for(int i:times){
                finishTime+=(mid/i);
            }
            if(finishTime<n) left=mid+1;
            else{
                if(mid<answer)
                    answer=mid;
                right=mid-1;
            }
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(6,new int[]{7,10}));
    }
}
