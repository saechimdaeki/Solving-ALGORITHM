package LeetCode_2021May_JumpGameII;


class Solution {
    public int jump(int[] nums) {
        int answer=0,end=0,cnt=0;
        for(int i=0; i<nums.length; i++){
            if(end==nums.length-1) break;
            cnt=Math.max(cnt,i+nums[i]);
            if(i==end){
                end=cnt;
                answer++;
            }
        }
        return answer;
    }
}
