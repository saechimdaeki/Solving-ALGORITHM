package 프로그래머스.다음큰숫자;
class Solution {
    public int solution(int n) {
        String tempn=Integer.toBinaryString(n);// tobinarystring 알아두자!
        int countn=0;
        for(int i=0; i<tempn.length(); i++){
            if(tempn.charAt(i)=='1')
                countn++;
        }
        while (true){
            n++;
            int cnt=0;
            String tempnext=Integer.toBinaryString(n);
            for(int i=0; i<tempnext.length(); i++){
                if(tempnext.charAt(i)=='1')
                    cnt++;
            }
            if(cnt==countn)
                return n;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(78)); //83
        System.out.println(s.solution(15));//23
    }
}
