package LeetCode1748;

import java.util.*;
class Solution {
    public int sumOfUnique(int[] nums) {
        int answer=0;
        Map<Integer, Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> iter:map.entrySet()){
            if(iter.getValue()==1)
                answer+=iter.getKey();
        }
        return answer;
    }
}
