package 프로그래머스_행렬_테두리_회전하기;

import java.util.Arrays;

class Solution {


    static int[][] grid;
    static int min=Integer.MAX_VALUE;
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        grid=new int[rows][columns];
        int cnt=1;
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < columns; j++)
                grid[i][j] = cnt++;
        }

        for(int i=0; i< queries.length; i++){
            int[] queryRow=queries[i];
            answer[i]= circle(queryRow);
        }

        return answer;
    }

    public static int circle(int[] queryRow){
        int startX=queryRow[0]-1;
        int startY=queryRow[1]-1;
        int endX=queryRow[2]-1;
        int endY=queryRow[3]-1;
        int nowx=startX;
        int nowy=startY;
        int temp = grid[nowx][nowy];
        min=temp;

        //오른쪽
        for(int i = startY; i < endY; i++) {
            int tmp=grid[nowx][++nowy];
            min=Math.min(tmp,min);
            grid[nowx][nowy]=temp;
            temp=tmp;
        }

        // 아래
        for(int i = startX; i < endX; i++) {
            int tmp=grid[++nowx][nowy];
            min=Math.min(tmp,min);
            grid[nowx][nowy]=temp;
            temp=tmp;
        }

        // 왼쪽
        for(int i = startY; i < endY; i++) {
            int tmp=grid[nowx][--nowy];
            min=Math.min(tmp,min);
            grid[nowx][nowy]=temp;
            temp=tmp;
        }

        // 위쪽
        for(int i = startX; i < endX; i++) {
            int tmp=grid[--nowx][nowy];
            min=Math.min(tmp,min);
            grid[nowx][nowy]=temp;
            temp=tmp;
        }
        return min;
    }

}

class Main{
    public static void main(String[] args) {
        int[] solution = Solution.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        Arrays.stream(solution).forEach(System.out::print); // 8 10 25
        System.out.println();
        int[] solution1 = Solution.solution(3, 3, new int[][]{{1, 1, 2, 2,}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
        Arrays.stream(solution1).forEach(System.out::print); // 1,1,5,3
        System.out.println();
        int[] solution2 = Solution.solution(100, 97, new int[][]{{1,1,100,97}});
        Arrays.stream(solution2).forEach(System.out::print); // 1



    }
}