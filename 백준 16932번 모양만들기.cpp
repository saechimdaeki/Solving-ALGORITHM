#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
using namespace std;
struct dir{
	int x,y;
};
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
int n,m,answer;
int grid[1000][1000];
int grouped[1000][1000];
int groupsize[1000*1000];
void bfs(int x, int y)
{
	answer++;
	queue<pair<int, int > >q;
	q.push({x,y});
	grouped[x][y]=answer;
	int cnt(1);
	while(!q.empty())
	{
		tie(x,y)=q.front();
		q.pop(); 
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx && nextx<n && 0<=nexty && nexty<m)
			{
				if(grid[nextx][nexty]==1 && grouped[nextx][nexty]==0)
				{
					grouped[nextx][nexty]=answer;
					q.push({nextx,nexty});
					cnt++;
				}
			}
		}
	}
	groupsize[answer]=cnt;
}
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
		for(int j=0; j<m; j++)
			cin>>grid[i][j];
	
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(grid[i][j]==1 && grouped[i][j]==0)
				bfs(i,j);
		}
	}
	int ans(0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(grid[i][j]==0)
			{
				vector<int> near;
				for(int k=0; k<4; k++)
				{
					int nextx=i+quad[k].x;
					int nexty=j+quad[k].y;
					if(0<=nextx && nextx<n && 0<=nexty && nexty<m)
					{
						if(grid[nextx][nexty]==1)
						near.push_back(grouped[nextx][nexty]);
					}
				}
				sort(near.begin(),near.end());
				near.erase(unique(near.begin(),near.end()),near.end());
				int sum(1);
				for(int a:near)
				sum+=groupsize[a];
				ans=max(ans,sum);
			}
		}
	}
	cout<<ans;
}
