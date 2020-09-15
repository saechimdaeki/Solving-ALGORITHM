package 프로그래머스.가장큰정사각형찾기;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] arr=new int[board.length+1][board[0].length+1];
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==1)
                    arr[i+1][j+1]=1;
                else
                    arr[i+1][j+1]=0;
            }
        }
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[0].length; j++){
                if(arr[i][j]==1){
                    int tmp=Math.min(arr[i-1][j],arr[i][j-1]);
                    tmp=Math.min(tmp,arr[i-1][j-1]);
                    arr[i][j]=tmp+1;
                    answer=Math.max(answer,arr[i][j]);
                }
            }
        }
        return (int)Math.pow(answer,2);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        System.out.println(s.solution(new int[][]{{0,0,1,1},{1,1,1,1}}));

    }
}
