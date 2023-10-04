package 자바.프로그래머스.양과_늑대;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    static int answer = 0;

    public static int solution(int[] info, int[][] edges) {
        List<List<Integer>> list = IntStream.range(0, info.length).<List<Integer>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());
        Arrays.stream(edges).forEachOrdered(edge -> list.get(edge[0]).add(edge[1]));

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(info, next, list,0, 0, 0);
        return answer;
    }

    public static void dfs(int[] info, List<Integer> next, List<List<Integer>> list, int node, int sheep, int wolf) {
        if (info[node] == 0)
            sheep++;
        else
            wolf++;
        if (sheep <= wolf)
            return;
        answer = Math.max(answer, sheep);
        List<Integer> nextNode = new ArrayList<>(next);
        if (!list.get(node).isEmpty())
            nextNode.addAll(list.get(node));
        nextNode.remove(Integer.valueOf(node));
        for (int i = 0, nextNodeSize = nextNode.size(); i < nextNodeSize; i++) {
            Integer integer = nextNode.get(i);
            dfs(info, nextNode, list, integer, sheep, wolf);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1},new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}})); // 5
        System.out.println(solution(new int[]{0,1,0,1,1,0,1,0,0,1,0},new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}})); // 5
    }
}