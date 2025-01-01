package programmers.notool_방문길이;

class Solution {
    static boolean[][][] visited = new boolean[11][11][4]; // 0 상 1 하 2 좌 3 우
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5, d = 0;
        
        for (int i = 0; i < dirs.length(); i ++) {
            char c = dirs.charAt(i);
            if (c == 'U')
                d = 0;
            if (c == 'D')
                d = 1;
            if (c == 'L')
                d = 2;
            if (c == 'R')
                d = 3;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx<0 || nx>=11 || ny < 0 || ny >=11) continue;
            if(!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[nx][ny][d % 2 == 0 ? d + 1 : d - 1] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}