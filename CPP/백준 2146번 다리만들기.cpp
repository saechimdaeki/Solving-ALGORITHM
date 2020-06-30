#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
int grid[101][101];
int grouped[101][101];
int distan[101][101];
int n,cnt;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>grid[i][j];
			// 1(land) or 0(sea)
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(grid[i][j]==1 && grouped[i][j]==0)
			{
				cnt++;
				grouped[i][j]=cnt;
				queue<pair<int, int > > q;
				q.push({i,j});
				while(!q.empty())
				{
					int x(q.front().first),y(q.front().second);
					q.pop();
					for(int k=0; k<4; k++)
					{
						int nextx(x+quad[k].x),nexty(y+quad[k].y);
						if(0<=nextx && nextx<n && 0<=nexty && nexty<n)
						{
							if(grid[nextx][nexty]==1 && grouped[nextx][nexty]==0)
							{
								grouped[nextx][nexty]=cnt;
								q.push({nextx,nexty});
								
							}
						}
					}
				}
			}
		}
	}
	queue<pair<int, int > > q;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			distan[i][j]=-1;
			if(grid[i][j]==1)
			{
				q.push({i,j});
				distan[i][j]=0;
			}
		}
	}
	while(!q.empty())
	{
		int x(q.front().first),y(q.front().second);
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx && nextx <n && 0<=nexty && nexty<n)
			{
				if(distan[nextx][nexty]==-1)
				{
					distan[nextx][nexty]=distan[x][y]+1;
					grouped[nextx][nexty]=grouped[x][y];
					q.push({nextx,nexty});
				}
			}
		}
	}
	int ans(-2e9+1);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			for(int k=0; k<4; k++)
			{
				int x(i+quad[k].x),y(j+quad[k].y);
				if(0<=x && x<n && 0<=y && y<n)
				{
					if(grouped[i][j]!=grouped[x][y])
					{
						if(ans==-2e9+1 ||ans>distan[i][j]+distan[x][y])
							ans=distan[i][j]+distan[x][y];
					}
				}
			}
		}
	}
	cout<<ans;
			
}
