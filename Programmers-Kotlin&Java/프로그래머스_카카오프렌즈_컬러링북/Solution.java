package 프로그래머스_카카오프렌즈_컬러링북;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited= new boolean[m][n];
        for(int i=0; i< picture.length; i++){
            for(int j=0; j< picture[i].length; j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(bfs(i, j, m, n, picture, visited),maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int i, int j, int m, int n, int[][] picture, boolean[][] visited){
        int cnt=1;
        visited[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(i,j));
        while (!q.isEmpty()){
            Pair pair = q.poll();
            int nowx= pair.x;
            int nowy= pair.y;
            for(int k=0; k<4; k++){
                int nextx=nowx+dx[k];
                int nexty=nowy+dy[k];
                if(nextx<0||nextx>=m ||nexty<0 || nexty>=n) continue;
                if(!visited[nextx][nexty] && picture[nowx][nowy]==picture[nextx][nexty]){
                    cnt++;
                    visited[nextx][nexty]= true;
                    q.offer(new Pair(nextx,nexty));
                }
            }
        }
        return cnt;
    }
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

class Main{
    public static void main(String[] args) {
        int[] solution1 = Solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        Arrays.stream(solution1).forEachOrdered(System.out::print); // [2,6]


        int[] solution = Solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        Arrays.stream(solution).forEachOrdered(System.out::print); // [4, 5]
    }
}

