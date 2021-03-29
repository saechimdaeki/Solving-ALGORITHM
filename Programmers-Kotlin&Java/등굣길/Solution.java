package 등굣길;

class Solution {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp=new int[n+1][m+1];
        for(int i=0; i< puddles.length; i++){
            int[] puddle = puddles[i];
            dp[puddle[1]-1][puddle[0]-1]=-1;
        }
        dp[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0; continue;
                }
                if(i!=0)
                    dp[i][j]+=dp[i-1][j]%1000000007;
                if(j!=0)
                    dp[i][j]+=dp[i][j-1]%1000000007;
            }
        }
        return dp[n-1][m-1]%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(solution(4,3,new int[][]{{2,2}}));

    }
}