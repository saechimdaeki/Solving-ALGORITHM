package LeetCode_2021May_DeleteOperationForTwoStrings;

import java.util.stream.IntStream;

class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[][] dp=new int[n+1][m+1];
        IntStream.rangeClosed(0, n).forEachOrdered(i -> dp[i][0] = i);
        IntStream.rangeClosed(0, m).forEachOrdered(j -> dp[0][j] = j);
        dp[0][0]=0;
        for(int i=1; i<=n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
        return dp[n-1][m-1];
    }
}
