package programmers.notool_연속_부분_수열_합의_개수;

import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i <2; i++)
            for (int j = 0; j <elements.length; j++)
                list.add(elements[j]);
        
        for (int i = 0; i < elements.length; i ++) {
            for (int j = 1; j <= elements.length; j++) {
                int sum = 0;
                List<Integer> tmp = list.subList(i, i+j);
                for (int n : tmp)
                    sum+=n;
                set.add(sum);
            }
        }
        return set.size();
    }
}