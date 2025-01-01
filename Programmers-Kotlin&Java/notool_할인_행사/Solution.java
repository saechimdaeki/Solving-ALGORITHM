package programmers.notool_할인_행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++)
            map.put(want[i], number[i]);
        
        int day = 10;
        
        for (int i = 0; i < discount.length - day + 1; i ++) {
            Map<String,Integer> tmp = new HashMap<>();
            
            for (int j = 0; j < day; j++) {
                tmp.put(discount[i+j], tmp.getOrDefault(discount[i+j],0) + 1);
            }
            
            boolean can = true;
            
            for (String key : map.keySet()) {
                if (map.get(key) != tmp.get(key)) {
                    can = false;
                    break;
                }
            }
            if (can)
                answer++;
        }
        
        
        return answer;
    }
}