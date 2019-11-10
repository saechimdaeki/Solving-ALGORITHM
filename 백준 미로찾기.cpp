#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
using namespace std;
#define endl '\n'
int grid[101][101];
bool visited[101][101];
int n,m;
typedef struct{
	int x,y;
}quad;
quad dir[4]={{0,1},{0,-1},{1,0},{-1,0}};
queue<pair<int, int> > q;
int a;
void bfs()
{
	q.push({0,0});
	visited[0][0]=true;
	
	while(!q.empty())
	{
		int nowx=q.front().first;
		int nowy=q.front().second;
		int b(0);
		q.pop();
		for(int i=0; i<4; i++)
		{
			int curx(nowx+dir[i].x);
			int cury(nowy+dir[i].y);
			if(0<=curx && curx < n && 0<=cury && cury<m)
			{
				if(grid[curx][cury] && !visited[curx][cury])
				{
					q.push({curx,cury});
					visited[curx][cury]=true;
					grid[curx][cury]=grid[nowx][nowy]+1;  //이부분 인터넷봄 한 line  
				}
			}
		}
			
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		for(int j=0; j<m; j++)
		grid[i][j]=s[j]-'0';
	}
	bfs();
	cout<<grid[n-1][m-1];
	

}
