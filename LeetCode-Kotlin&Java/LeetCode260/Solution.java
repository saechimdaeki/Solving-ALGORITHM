package LeetCode260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/* 260. Single Number III */
class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.stream(nums).forEachOrdered(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        map.forEach((key, value) -> {
            if (value == 1)
                list.add(key);
        });
        return list.stream().mapToInt(integer -> integer).toArray();
    }
}


