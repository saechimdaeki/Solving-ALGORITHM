package 자바.leetcode.Find_All_Numbers_Disappeared_In_An_Array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return  IntStream.rangeClosed(1, nums.length).filter(i -> !set.contains(i)).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println((findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}))); // [5,6]
        System.out.println(findDisappearedNumbers(new int[]{1,1})); // [2]
    }
}