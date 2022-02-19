package 프로그래머스_최고순위와_최저순위;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt= (int) Arrays.stream(lottos).filter(lotto -> lotto == 0).count();
        Set<Integer> set= Arrays.stream(lottos).boxed().collect(Collectors.toSet());
        int cnt= (int) Arrays.stream(win_nums).filter(set::contains).count();
        answer[0]=prize(cnt+zeroCnt);
        answer[1]=prize(cnt);

        return answer;
    }
    public static int prize(int cnt){
        switch (cnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}

class Main{
    public static void main(String[] args) {
        int[] solution1 = Solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}); // 3,5
        for (int i : solution1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] solution2 = Solution.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});//1,6
        for (int i : solution2) {
            System.out.print(i+" ");
        }
        System.out.println();

        int[] solution3 = Solution.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}); // 1,1
        for (int i : solution3) {
            System.out.print(i+" ");
        }
    }
}
