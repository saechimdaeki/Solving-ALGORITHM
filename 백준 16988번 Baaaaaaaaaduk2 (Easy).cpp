#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<tuple>
#include<cstring>
using namespace std;
struct dir{
	int x,y;
};
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
int n,m,answer;
int grid[20][20];
bool visited[20][20];

int bfs()
{
	memset(visited,false,sizeof(visited));
	int ans(0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(grid[i][j]==2 && !visited[i][j])
			{
				bool deadpool(true);
				queue<pair<int, int> > q;
				q.push({i,j});
				visited[i][j]=true;
				int cur(0);
				while(!q.empty())
				{
					cur++;
					int x,y;
					tie(x,y)=q.front();
					q.pop();
					for(int i=0; i<4; i++)
					{
						int nextx(x+quad[i].x),nexty(y+quad[i].y);
						if(0<=nextx&&nextx<n && 0<=nexty && nexty<m)
						{
							if(grid[nextx][nexty]==0)
							deadpool=false;
							else if(grid[nextx][nexty]==2 && !visited[nextx][nexty])
							{
								q.push({nextx,nexty});
								visited[nextx][nexty]=true;
							}
						}
					}
				}
				if(deadpool)
				ans+=cur;
			}
		}
	}
	return ans;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
		for(int j=0;j<m;j++)
			cin>>grid[i][j];
	for(int x1=0; x1<n; x1++)
	{
		for(int y1=0; y1<m; y1++)
		{
			if(grid[x1][y1]!=0)
			continue;
			for(int x2=0; x2<n; x2++)
			{
				for(int y2=0; y2<m; y2++)
				{
					if(x1==x2 && y1==y2)
					continue;
					if(grid[x2][y2]!=0)
					continue;
					grid[x1][y1]=grid[x2][y2]=1;
					int current(bfs());
					answer=max(answer,current);
					grid[x1][y1]=grid[x2][y2]=0;			
				}	
			}	
		}
	}	
	cout<<answer;	
}
