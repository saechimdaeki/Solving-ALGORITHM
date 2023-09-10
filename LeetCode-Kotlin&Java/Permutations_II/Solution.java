package 자바.leetcode.Permutations_II;

import java.util.*;

class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> uniquePerms = new HashSet<>();

        dfs(nums,new ArrayList<>() ,uniquePerms, new boolean[nums.length]);

        return new ArrayList<>(uniquePerms);
    }

    public static void dfs(int[] nums, List<Integer> current ,Set<List<Integer>> uniquePerms, boolean[] visited) {
        if (nums.length == current.size()) {
            uniquePerms.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++ ) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            dfs(nums, current, uniquePerms, visited);
            visited[i] = false;
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}).toString()); // [[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(permuteUnique(new int[]{1,2,3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}