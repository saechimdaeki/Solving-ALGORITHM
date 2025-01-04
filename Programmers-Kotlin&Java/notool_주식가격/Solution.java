package programmers.notool_주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int now = prices[i];
            int cnt = 0;

            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (now > prices[j]) {
                    break;
                }
            }
            answer[i] = cnt;
        }
        answer[prices.length - 1] = 0;
        return answer;
    }
}