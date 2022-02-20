package 프로그래머스_거리두기_확인하기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i< places.length; i++){
            String[] place = places[i];
            boolean coronaSafety= true;
            for(int j= 0; j< place.length && coronaSafety ; j++){
                for(int k=0; k<place[j].length() && coronaSafety; k++){
                    if(place[j].charAt(k)=='P'){
                        if(!bfs(j,k,place)){
                            coronaSafety=false;
                        }
                    }
                }
            }
            answer[i]= coronaSafety ? 1: 0;
        }

        return answer;
    }
    public static boolean bfs(int j, int k, String[] place){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(j,k));
        while (!q.isEmpty()){
            Pair poll = q.poll();
            int nowX= poll.x;
            int nowY= poll.y;
            for(int i=0; i<4; i++){
                int nextX=nowX+dx[i];
                int nextY=nowY+dy[i];
                if(nextX<0 || nextX>=5 || nextY<0 || nextY>=5 ) continue;
                if(nextX==j && nextY==k) continue; //출발점 제외
                int coronaDistance = Math.abs(nextX-j) + Math.abs(nextY-k);
                if(place[nextX].charAt(nextY)=='P' && coronaDistance<=2) return false;
                else if (place[nextX].charAt(nextY)=='O' && coronaDistance<2) q.offer(new Pair(nextX,nextY)); //다음탐색시 증가.

            }

        }
        return true;
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
        int[] solution = Solution.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        Arrays.stream(solution).mapToObj(i -> i + " , ").forEachOrdered(System.out::print); // 1, 0, 1, 1, 1,
    }
}
