package 자바.leetcode.Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(),nums, new boolean[nums.length]);
        return answer;
    }

    public static void dfs(List<List<Integer>> answer, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            current.add(nums[i]);
            visited[i] = true;
            dfs(answer,current,nums,visited);
            visited[i] = false;
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permute(new int[]{0,1})); //  [[0,1], [1,0]]
        System.out.println(permute(new int[]{1})); // [[1]]
    }
}