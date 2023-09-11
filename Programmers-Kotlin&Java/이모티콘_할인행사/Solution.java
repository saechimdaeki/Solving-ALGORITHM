package 자바.프로그래머스.이모티콘_할인행사;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    static int maxCost;
    static int maxSubscribe;
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] disCountRate = {10, 20, 30, 40};

        dfs(0, emoticons, disCountRate, users, new int[emoticons.length] );


        return new int[]{maxSubscribe, maxCost};
    }

    public static void dfs(int index, int[] emotions, int[] discountRate, int[][] users, int[] discounts) {
        if (index == emotions.length) {
            int subs = 0;
            int costs = 0;
            for (int[] user : users) {
                int userDiscount = user[0];
                int userPossibleCost = user[1];

                int sum = IntStream.range(0, emotions.length).filter(i -> discounts[i] >= userDiscount).
                        map(i -> emotions[i] / 100 * (100 - discounts[i])).sum();
                if (sum >= userPossibleCost) subs++;
                else costs += sum;
            }
            if (subs > maxSubscribe) {
                maxCost = costs;
                maxSubscribe = subs;
            } else if (subs == maxSubscribe)
                maxCost = Math.max(maxCost, costs);
            return;
        }
        IntStream.range(0, 4).forEach(i -> {
            discounts[index] = discountRate[i];
            dfs(index + 1, emotions, discountRate, users, discounts);
        });
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000,9000}))); // [1, 5400]
        System.out.println(Arrays.toString(solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200},
                {32, 6900}}, new int[]{1300, 1500, 1600, 4900}))); // [4, 13860]

    }
}