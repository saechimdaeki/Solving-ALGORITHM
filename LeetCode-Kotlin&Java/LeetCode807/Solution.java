package LeetCode807;

/* 807. Max Increase to Keep City Skyline */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length= grid.length;
        int answer=0;
        int[] a=new int[length];
        int[] b=new int[length];

        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                a[i]=Math.max(a[i],grid[i][j]);
                b[i]=Math.max(b[i],grid[j][i]);
            }
        }
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                answer+= (Math.min(a[i],b[j])-grid[i][j]);
            }
        }


        return answer;
    }
}
