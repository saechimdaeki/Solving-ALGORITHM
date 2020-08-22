#include<iostream>
#include<algorithm>
#include<queue>
#include<tuple>
#include<vector>
#include<cstring>
using namespace std;
struct dir{
	int x,y;
};
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
int grid[101][101];
int dist[101][101];
int n,m;
vector<pair<int, int > >v;
int answer(-1);
void bfs(){
	memset(dist,-1,sizeof(dist));
	queue<pair<int, int > >q;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(grid[i][j]==3)
			{
				q.push({i,j});
				dist[i][j]=0;
			}
		}
	}
	while(!q.empty())
	{
		int x,y;
		tie(x,y)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nx(x+quad[i].x),ny(y+quad[i].y);
			if(0<=nx && nx<n && 0<=ny && ny<n)
			{
				if(grid[nx][ny]!=1 && dist[nx][ny]==-1)
				{
					dist[nx][ny]=dist[x][y]+1;
					q.push({nx,ny});
				}
			}
		}
	}
	int current(0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(grid[i][j]!=1)
			{
				if(dist[i][j]==-1)
				return;
				if(current<dist[i][j])
				current=dist[i][j];
			}
		}
	}
	if(answer==-1 || answer>current)
	answer=current;
}

void dfs(int idx, int cnt)
{
	if(idx==v.size())
	{
		if(cnt==m)
		bfs();
	}else{
		int x,y;
		tie(x,y)=v[idx];
		grid[x][y]=3;
		dfs(idx+1,cnt+1);
		grid[x][y]=0;
		dfs(idx+1,cnt);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			cin>>grid[i][j];
			if(grid[i][j]==2)
			{
				grid[i][j]=0;
				v.emplace_back(i,j);
			}
		}
	}
	dfs(0,0);
	cout<<answer;
}

 
