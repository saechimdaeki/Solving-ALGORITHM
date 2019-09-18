#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#define endl '\n'
using namespace std;
char grid[251][251];
bool visited[251][251];
int yang,wolf;
int yangnow,wolfnow;
int r,c;
typedef struct{
	int x,y;
}quad;

quad dir[4]={{-1,0},{1,0},{0,-1},{0,1}};
void bfs(int a,int b)
{
	yangnow=0;wolfnow=0;
	queue<pair<int, int> > q;
	visited[a][b]=true;
	q.push({a,b});
	if(grid[a][b]=='o')
	yangnow++;
	else if(grid[a][b]=='v')
	wolfnow++;
	while(!q.empty())
	{
		int nowx(q.front().first);
		int nowy(q.front().second);
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(nowx+dir[i].x);
			int nexty(nowy+dir[i].y);
			if(0<=nextx &&nextx<r && 0<=nexty &&nexty<c &&visited[nextx][nexty]==false &&(grid[nextx][nexty]=='.'||grid[nextx][nexty]=='v'||grid[nextx][nexty]=='o'))
			{
				visited[nextx][nexty]=true;
				if(grid[nextx][nexty]=='v')
				wolfnow++;
				else if(grid[nextx][nexty]=='o')
				yangnow++;
				q.push({nextx,nexty});
			}
		}
	}
	if(wolfnow>=yangnow)
	yang-=yangnow;
	else if(wolfnow<yangnow)
	wolf-=wolfnow;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>r>>c;
	for(int i=0; i<r; i++)
	{
		for(int j=0; j<c; j++)
		{
			cin>>grid[i][j];
			if(grid[i][j]=='v')
			wolf++;
			else if(grid[i][j]=='o')
			yang++;
		}
	}
	for(int i=0; i<r; i++)
	{
		for(int j=0; j<c; j++)
		{
			if(grid[i][j]=='o'&&visited[i][j]==false)
			bfs(i,j);
			if(grid[i][j]=='v'&&visited[i][j]==false)
			bfs(i,j);
		}
	}
	
	
	cout<<yang<<' '<<wolf;
}
