package 프로그래머스.비밀지도;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            int tmp=(arr1[i] | arr2[i]);
            StringBuilder temp= new StringBuilder();
            for(int j=0; j<n; j++)
                temp.append(" ");
            for(int j=n-1; j>=0; j--){
                if(tmp%2==0)
                    temp.setCharAt(j,' ');
                else
                    temp.setCharAt(j,'#');
                tmp/=2;
            }
            answer[i]=temp.toString();
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        String[] answer1=s.solution(5,new int[]{9,20,28,18,11},new int[]{30,1,21,17,28});
        for(String i:answer1){
            System.out.print(i+" ");
        }
        System.out.println();
        String[] answer2=s.solution(6,new int[]{46,33,32,22,31,50},new int[]{27,56,19,14,14,10});
        for(String i:answer2)
            System.out.print(i+" ");

    }
}
