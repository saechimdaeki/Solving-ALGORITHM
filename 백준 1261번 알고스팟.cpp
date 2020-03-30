#include<iostream>
#include<algorithm>
#include<queue>
#include<tuple>
#include<cstring>
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,-1},{0,1}};
int n,m,cnt;
string s;
int grid[101][101];
int dist[101][101];
queue<pair<int, int > > q;
queue<pair<int, int > > breakq;
void bfs(int x, int y)
{
	q.push({x,y});
	dist[x][y]=0;
	while(!q.empty())
	{
		tie(x,y)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx && nextx<n &&0<=nexty && nexty<m)
			{
				if(dist[nextx][nexty]==-1)
				{
					if(grid[nextx][nexty]==0)
					{
						dist[nextx][nexty]=dist[x][y];
						q.push({nextx,nexty});	
					}else{
					dist[nextx][nexty]=dist[x][y]+1;
					breakq.push({nextx,nexty});
				}	
			}	
		}
	}
		if(q.empty())
		{
			q=breakq;
			breakq=queue<pair<int, int> >();
		}
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);	
	cin>>m>>n;
	for(int i=0; i<n; i++)
	{
		cin>>s;
		for(int j=0; j<m; j++)
			grid[i][j]=s[j]-'0';
	}
	memset(dist,-1,sizeof(dist));
	bfs(0,0);
	cout<<dist[n-1][m-1]; 
} 
