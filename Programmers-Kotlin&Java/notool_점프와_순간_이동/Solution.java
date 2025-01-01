package programmers.notool_점프와_순간_이동;

import java.util.*;

public class Solution {
    static int ans = Integer.MAX_VALUE;
    public int solution(int n) {
        dfs(n,0);
        return ans;
    }
    public void dfs(int n, int cnt) {
        if (n == 0 ){
            ans = Math.min(ans, cnt);
            return;
        }
        if (n%2==0)
            dfs(n/2,cnt);
        else
            dfs(n-1,cnt+1);
    }
}