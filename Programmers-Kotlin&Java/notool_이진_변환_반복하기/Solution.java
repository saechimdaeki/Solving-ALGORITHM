package programmers.notool_이진_변환_반복하기;

class Solution {
    public int[] solution(String s) {
        int changeCnt = 0;
        int zeroCnt = 0;
        while (s.length() > 1) {
            int oneCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    zeroCnt++;
                else
                    oneCnt++;
            }
            
            s = Integer.toBinaryString(oneCnt);
            
            changeCnt++;
        }
            
        return new int[]{changeCnt, zeroCnt};
        
    }
}