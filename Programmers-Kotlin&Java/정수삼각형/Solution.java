package 정수삼각형;


class Solution {
    public static int solution(int[][] triangle) {
        int size=triangle.length;
        int[][] dp=new int[size+1][size+1];
        dp[0][0]=triangle[0][0];
        int answer=dp[0][0];

        for(int i=1; i<size; i++){
            for(int j= 0; j<=i; j++){
                if(j==0) // Left
                    dp[i][j]=dp[i-1][j]+triangle[i][j];
                else if(j==i) //Right
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                else  //Center
                    dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
                answer=Math.max(answer,dp[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}})); //30
    }
}


