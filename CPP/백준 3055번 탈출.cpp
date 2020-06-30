#include<iostream>
#include<tuple>
#include<algorithm>
#include<cstring>
#include<queue>
using namespace std;
int water[50][50];
int gosum[50][50];
vector<string> v;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
int sx,sy,ex,ey;
queue<pair<int,int>> waterq;
queue<pair<int,int>> gosumq;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    int r, c;
    cin>>r>>c;
    v.resize(r);
    for (int i=0; i<r; i++) 
        cin>>v[i];
    memset(water,-1,sizeof(water));
    
    for (int i=0; i<r; i++) {
        for (int j=0; j<c; j++) {
            if (v[i][j] == '*') {
                waterq.push(make_pair(i,j));
                water[i][j] = 0;
            }
			if(v[i][j]=='S'){
                sx = i;
                sy = j;
            }
			if(v[i][j]=='D') {
                ex = i;
                ey = j;
            }
        }
    }
    while (!waterq.empty()) {
        int x, y;
        tie(x,y) = waterq.front();
		waterq.pop();
        for (int i=0; i<4; i++) {
            int nx=x+quad[i].x;
            int ny=y+quad[i].y;
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (water[nx][ny] != -1) continue;
            if (v[nx][ny] == 'X') continue;
            if (v[nx][ny] == 'D') continue;
            water[nx][ny] = water[x][y] + 1;
            waterq.push(make_pair(nx,ny));
        }
    }
    memset(gosum,-1,sizeof(gosum));
    gosumq.push(make_pair(sx,sy));
    gosum[sx][sy] = 0;
    while (!gosumq.empty()) {
        int x, y;
        tie(x,y) = gosumq.front();
		gosumq.pop();
        for (int i=0; i<4; i++) {
            int nx=x+quad[i].x;
            int ny=y+quad[i].y;
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (gosum[nx][ny] != -1) continue;
            if (v[nx][ny] == 'X') continue;
            if (water[nx][ny] != -1 && gosum[x][y]+1 >= water[nx][ny]) continue;
            gosum[nx][ny] = gosum[x][y] + 1;
            gosumq.push(make_pair(nx,ny));
        }
    }
    if (gosum[ex][ey] == -1)
        cout << "KAKTUS";
	else 
        cout << gosum[ex][ey];

}
