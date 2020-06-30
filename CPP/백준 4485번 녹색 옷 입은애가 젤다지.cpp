#include<iostream>
#include<queue>
#include<tuple>
#include<algorithm>
#include<cstring>
#define endl '\n'
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
int n,answer;
int grid[125][125];
int dist[125][125];

void bfs()
{
	dist[0][0]=grid[0][0];
	queue<pair<int, int> > q;
	q.push({0,0});
	while(!q.empty())
	{
		int x,y;
		tie(x,y)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx&&nextx<n&&0<=nexty&&nexty<n)
			{
				if(dist[nextx][nexty]>(dist[x][y]+grid[nextx][nexty]))
				{
					dist[nextx][nexty]=(dist[x][y]+grid[nextx][nexty]);
					q.push({nextx,nexty});
				}
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=1; ; i++)
	{
		cin>>n;
		if(n==0)
		break;
		for(int j=0; j<n; j++)
		{
			for(int k=0; k<n; k++)
			{
				cin>>grid[j][k];
			}	
		}
		memset(dist,2e9+1,sizeof(dist));
		bfs();
		cout<<"Problem "<<i<<": "<<dist[n-1][n-1]<<endl;
	}
	return 0;
	
}
