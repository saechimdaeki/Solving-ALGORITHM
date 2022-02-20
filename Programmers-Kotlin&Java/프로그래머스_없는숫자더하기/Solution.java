package 프로그래머스_없는숫자더하기;

import java.util.stream.IntStream;

class Solution {
    public static int solution(int[] numbers) {
        boolean[] checked=new boolean[10];
        IntStream.range(0, numbers.length).forEachOrdered(i1 -> checked[numbers[i1]] = true);
        return IntStream.range(0, 10).filter(i -> !checked[i]).sum();
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1,2,3,4,6,7,8,0})); //14
        System.out.println(Solution.solution(new int[]{5,8,4,0,6,7,9})); //6
    }
}
