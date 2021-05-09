package LeetCode442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* 442. Find All Duplicates in an Array */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> answer=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        Arrays.stream(nums).forEachOrdered(num -> {
            if (set.contains(num))
                answer.add(num);
            set.add(num);
        });


        return answer;
    }
}
