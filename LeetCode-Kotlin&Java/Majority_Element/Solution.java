package 자바.leetcode.Majority_Element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEachOrdered(num -> map.put(num, map.getOrDefault(num, 0) + 1));

        int max = 0;
        int answer = 0;
        for (Integer key : map.keySet())
            if (max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3})); // 3
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
    }
}
