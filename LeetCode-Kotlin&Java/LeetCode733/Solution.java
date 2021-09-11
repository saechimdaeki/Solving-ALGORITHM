package LeetCode733;

import java.util.*;
/* 733. Flood Fill */
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(sr,sc));
        int targetNum= image[sr][sc];
        if(targetNum == newColor) return image;
        int n=image.length;
        int m=image[0].length;
        image[sr][sc]=newColor;
        while(!q.isEmpty()){
            pair now = q.poll();
            int nowx = now.x;
            int nowy = now.y;
            for(int i=0; i<4; i++){
                int nextx=nowx+dx[i];
                int nexty=nowy+dy[i];
                if(nextx<0 || nextx>=n || nexty<0 || nexty>=m) continue;

                if(image[nextx][nexty]==targetNum){
                    image[nextx][nexty]=newColor;
                    q.offer(new pair(nextx,nexty));
                }
            }
        }
        return image;
    }
    static class pair{
        int x;
        int y;

        public pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
