package 프로그래머스.N으로표현;
class Solution {
    int answer=-1;
    public int solution(int N, int number) {
        dfs(0,0,N,number);
        return answer;
    }
    public void dfs(int count,int previous,int N,int number){
        int temp=N;
        if(count>8){
            answer=-1;
            return;
        }
        if(number==previous){
            if(answer==-1 || answer>count)
                answer=count;
            return;
        }
        for(int i=0; i<8-count; i++){
            dfs(count+i+1,previous-temp,N,number);
            dfs(count+i+1,previous+temp,N,number);
            dfs(count+i+1,previous*temp,N,number);
            dfs(count+i+1,previous/temp,N,number);
            temp=temp*10+N;
        }

    }
}
public class n으로표현 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(5,12));//4
        System.out.println(s.solution(2,11));//3
    }
}
