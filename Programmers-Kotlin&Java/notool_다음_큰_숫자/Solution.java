package programmers.notool_다음_큰_숫자;

import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryn = Integer.toBinaryString(n);
        int cntN = 0 ;
        for (int i = 0; i < binaryn.length(); i ++) 
            if (binaryn.charAt(i) == '1')
                cntN++;
        
        for (int i = n+1 ; i <1000000; i++) {
            int cnt = 0 ;
            
            String binaryBig = Integer.toBinaryString(i);
            for (int j = 0; j < binaryBig.length(); j ++) 
                if (binaryBig.charAt(j) == '1')
                    cnt++;
            
            if (cnt == cntN)
                return i;
        }
        
        return answer;
    }
}