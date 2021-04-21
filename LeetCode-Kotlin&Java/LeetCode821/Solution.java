package LeetCode821;

import java.util.*;

/* 821. Shortest Distance to a Character */
class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] answer=new int[s.length()];
        List<Integer> targetNumber=new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c) targetNumber.add(i);
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c) answer[i]=0;
            else{
                int tmp=Integer.MAX_VALUE;
                for (Integer integer : targetNumber) {
                    tmp = Math.min(tmp, Math.abs(integer - i));
                }
                answer[i]=tmp;
            }
        }
        return answer;
    }
}
