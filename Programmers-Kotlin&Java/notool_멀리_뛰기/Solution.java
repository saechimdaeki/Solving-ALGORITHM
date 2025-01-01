package programmers.notool_멀리_뛰기;

class Solution {
    static int divide = 1234567;
    static long answer = 0;

    public long solution(int n) {
        
        long[] dp = new long[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%divide;
        }
        
        return dp[n]%divide;
    }
    
}