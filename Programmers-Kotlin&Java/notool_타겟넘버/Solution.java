package programmers.notool_타겟넘버;

class Solution {
    public int solution(int[] numbers, int target) {        
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        return dfs(numbers,target, sum+ numbers[idx], idx+1) + dfs(numbers,target,sum-numbers[idx], idx+1);
    }
}