package 프로그래머스.예상대진표;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer=0;
        while (true){
            if(a==b) break;
            if(b%2==1) b=b/2+1;
            else b/=2;
            if(a%2==1) a=a/2+1;
            else a/=2;
            answer++;
        }
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(8,4,7));
    }
}
