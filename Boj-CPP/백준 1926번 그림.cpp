#include<iostream>
#include<algorithm>
#define endl '\n'
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{1,0},{-1,0},{0,1},{0,-1}};

int grid[501][501];
bool visited[501][501];
int n,m;
int cnt;
int solve(0),answer;
void dfs(int x, int y)
{
	cnt++;
	visited[x][y]=true;
	for(int i=0; i<4; i++)
	{
		int nextx(x+quad[i].x);
		int nexty(y+quad[i].y);
		if(0<=nexty && nexty<m && 0<=nextx && nextx<n)
		{
			if(grid[nextx][nexty]&& visited[nextx][nexty]==false)
				dfs(nextx,nexty);
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
		for(int j=0; j<m; j++)
		{
			cin>>grid[i][j];
		}
	}
	for(int i=0; i<n; i++)
	{
		for (int j=0; j<m; j++)
		{
			if (visited[i][j]==false && grid[i][j])
			{
				cnt=0;;
				dfs(i,j);
				answer=max(answer,cnt);
				solve++;
			}
		}
	}
	cout<<solve<<endl;
	cout<<answer;
	
	
}
