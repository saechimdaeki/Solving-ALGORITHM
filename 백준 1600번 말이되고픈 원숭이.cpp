#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
struct dir{
	int x,y;
};
dir quad[12]={{0,1},{0,-1},{1,0},{-1,0},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
int cost[] = {0,0,0,0,1,1,1,1,1,1,1,1};
int k,n,m;
int grid[200][200];
int dist[200][200][31];



int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>k>>m>>n;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
			cin>>grid[i][j];
	}
	memset(dist,-1,sizeof(dist));
	queue<tuple<int,int,int>>q;
	dist[0][0][0]=0;
	q.push(make_tuple(0,0,0));
	while(!q.empty())
	{
		int x,y,z;
		tie(x,y,z)=q.front();
		q.pop();
		for(int i=0; i<12; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y),nextz(z+cost[i]);
			if(0<=nextx && nextx<n && 0<=nexty && nexty<m)
			{
				if(grid[nextx][nexty]==1)
				continue;
				if(nextz<=k)
				{
					if(dist[nextx][nexty][nextz]==-1)
					{
						dist[nextx][nexty][nextz]=dist[x][y][z]+1;
						q.push(make_tuple(nextx,nexty,nextz));
					}
				}
			}
		}
	}
	int answer=-1;
	for(int i=0; i<=k; i++)
	{
		if(dist[n-1][m-1][i]==-1)
		continue;
		if(answer==-1 || answer>dist[n-1][m-1][i])
		answer=dist[n-1][m-1][i];
	}
	cout<<answer;
}
