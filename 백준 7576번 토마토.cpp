#include<iostream>
#include<queue>
#define endl '\n'
using namespace std;
int n,m;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{1,0},{-1,0},{0,1},{0,-1}};
int grid[1001][1001];
int checked[1001][1001];
queue<pair<int, int> >q;
int answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>m>>n;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			cin>>grid[i][j];
			checked[i][j]=-1;
			if(grid[i][j]==1)
			{
				q.push({i,j});
				checked[i][j]=0;
			}
		}
	}
	while(!q.empty())
	{
		int x(q.front().first);
		int y(q.front().second);
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x);
			int nexty(y+quad[i].y);
			if(0<=nextx && nextx<n && 0<=nexty && nexty<m)
			{
				if(grid[nextx][nexty]==0 && checked[nextx][nexty]==-1)
				{
					checked[nextx][nexty]=checked[x][y]+1;
					q.push({nextx,nexty});
				}
			}
		}
	}
	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++)
		answer=max(answer,checked[i][j]);
		
	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++)
			if(grid[i][j]==0 && checked[i][j]==-1)
			answer=-1;
			
	cout<<answer;	
}
