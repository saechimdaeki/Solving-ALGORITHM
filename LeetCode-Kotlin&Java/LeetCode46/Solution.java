package LeetCode46;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    static List<List<Integer>> list;
    static boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        list=new ArrayList<>();
        visited=new boolean[nums.length];
        dfs(nums,new ArrayList<>());
        return list;
    }
    private void dfs(int[] nums,List<Integer> choice){
        if(choice.size()==nums.length){
            list.add(new ArrayList<>(choice));
            return;
        }
        IntStream.range(0, nums.length).filter(i -> !visited[i]).forEach(i -> {
            visited[i] = true;
            choice.add(nums[i]);
            dfs(nums, choice);
            visited[i] = false;
            choice.remove(choice.size() - 1);
        });
    }
}
