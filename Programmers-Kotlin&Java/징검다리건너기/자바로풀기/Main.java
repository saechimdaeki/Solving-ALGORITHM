package 프로그래머스.징검다리건너기.자바로풀기;

class Solution {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int right= Integer.MIN_VALUE;
        int left= Integer.MAX_VALUE;
        int[] copy=new int[stones.length];
        for(int i=0; i<stones.length; i++){
            left=Math.min(left,stones[i]);
            right=Math.max(right,stones[i]);
        }
        //System.out.println(left+" "+right);
        for(int i=0; i<stones.length; i++)
            copy[i]=stones[i];
        while (left<=right){
            int mid=(left+right)/2;
           // System.out.println(mid);
            if(possible(mid,copy.clone(),k)){
                answer=Math.max(answer,mid);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return answer;
    }
    public boolean possible(int mid,int[] copy,int k){
        for(int i=0; i<copy.length; i++)
            copy[i]-=mid;
        int cnt=0;
        for(int i=0; i<copy.length; i++){
            if(copy[i]<0){
                cnt++;
                if(cnt>=k){
                    return false;
                }
            }else cnt=0;
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(new int[]{2,4,5,3,2,1,4,2,5,1},3));
    }
}
