#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
int dist[51][51];
int grid[51][51];
int n,m;
struct dir{
	int x,y;
};
dir quad[8]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
int bfs(int x,int y)
{
	memset(dist,-1,sizeof(dist));
	queue<pair<int, int > > q;
	q.push({x,y});
	dist[x][y]=0;
	while(!q.empty())
	{
		tie(x,y)=q.front();
		q.pop();
		for(int i=0; i<8; i++)
		{
			int nx(x+quad[i].x),ny(y+quad[i].y);
			if(0<=nx && nx<n && 0<=ny && ny<m)
			{
				if(dist[nx][ny]==-1)
				{
					if(grid[nx][ny]==1)
					return dist[x][y]+1;
					else
					{
						q.push({nx,ny});
						dist[nx][ny]=dist[x][y]+1;
					}	
				}	
			}	
		}	
	}
	return 0;
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin>>n>>m;
	for(int i=0; i< n; i++)
		for(int j=0; j<m; j++)
			cin>>grid[i][j];
	int answer(0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(grid[i][j]==0)
			{
				int tmp=bfs(i,j);
				answer=max(answer,tmp);			
			}
		}		
	}		
	cout<<answer;
}
