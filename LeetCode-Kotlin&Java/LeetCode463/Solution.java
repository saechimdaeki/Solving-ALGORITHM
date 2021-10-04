package LeetCode463;

/* 463. Island Perimeter */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int round=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    round+=4;
                    if(i>0 && grid[i-1][j]==1)
                        round-=2;
                    if(j>0 && grid[i][j-1]==1)
                        round-=2;
                }
            }
        }
        return round;
    }
}
