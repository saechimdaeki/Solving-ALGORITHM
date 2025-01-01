package programmers.notool_영어_끝말잇기;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char previous = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        int idx = 0;
        for (int i = 1; i < words.length; i++) {
            idx++;
            if (previous != words[i].charAt(0)) {
                break;
            }
            if (set.contains(words[i])){
                break;
            }
            set.add(words[i]);
            previous = words[i].charAt(words[i].length() -1);
            if (i == words.length -1)
                return new int[]{0,0};
        }        
        
        return new int[]{idx%n +1, idx/n +1};
    }
}