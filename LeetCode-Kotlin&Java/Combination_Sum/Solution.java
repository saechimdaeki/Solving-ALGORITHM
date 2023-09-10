package 자바.leetcode.Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, target, 0 );

        return answer;
    }

    public void dfs(List<Integer> current, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i= start; i< candidates.length && target >= candidates[i]; i++) {
                current.add(candidates[i]);
                dfs(current, candidates, target - candidates[i], i);
                current.remove(current.size() -1);
            }
        } else if (target == 0)
            answer.add(new ArrayList<>(current));
    }
}

class Temp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7},7)); // [[2,2,3],[7]]
        System.out.println(solution.combinationSum(new int[]{2,3,5},8)); // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(solution.combinationSum(new int[]{2},1)); // []
    }
}