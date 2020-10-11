package 프로그래머스.소수만들기;

class Solution {
    public int solution(int[] nums) {
        int answer=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k< nums.length; k++){
                    if(soSoo(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }
        return answer;
    }
    public boolean soSoo(int n){
        if(n==1) return false;
        int bts=(int)Math.sqrt(n);
        for(int i=2; i<=bts; i++){
            if(n%i==0) return false;
        }
        return true;
    }

}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(new int[]{1,2,3,4})); //1
        System.out.println(s.solution(new int[]{1,2,7,6,4})); //4
    }
}
