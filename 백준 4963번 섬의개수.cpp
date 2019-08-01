#include <iostream>
#include <queue>
using namespace std;
int grid[50][50];
bool visited[50][50];
typedef struct{
	int x,y;
}dir;
dir quad[8]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
int w,h,count123;
queue<pair<int,int>> q;
void bfs(int x, int y) {
    q.push(make_pair(x,y));
    visited[x][y] = true;
    while (!q.empty()) {
        x=q.front().first;
        y=q.front().second;
        q.pop();
        for (int i=0; i<8; i++) {
            int curx(x+quad[i].x);
            int cury(y+quad[i].y);
            if (0 <= curx && curx < w && 0 <= cury && cury < h) {
                if (grid[curx][cury] == 1 && visited[curx][cury] == 0) {
                    q.push({curx,cury});
                    visited[curx][cury] = true;
                }
            }
        }
    }
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); 
    while (true) {
    	cin>>h>>w;
        if (w == 0 && h == 0)
		 break;
        for (int i=0; i<w; i++) {
            for (int j=0; j<h; j++) {
            cin>>grid[i][j];
            visited[i][j] = false;
            }
        }
         count123 = 0;
        for (int i=0; i<w; i++) {
            for (int j=0; j<h; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    count123++;
					bfs(i, j);
                }
            }
        }
        cout<<count123<<"\n";
    }
    return 0;
}
