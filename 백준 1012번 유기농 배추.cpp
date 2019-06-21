#include<iostream>
#include<algorithm>
#include<cstring>
int t,n,m,k;
int grid[51][51];
bool visited[51][51];
using namespace std;
typedef struct{
	int x,y;
}dir;

dir quad[4]={{-1,0},{1,0},{0,-1},{0,1}};

void dfs(int x,int y)
{
	if(visited[x][y])
	return;
	visited[x][y]=true;
	for(int i=0; i<4; i++)
	{
		int curx(x+quad[i].x);
		int cury(y+quad[i].y);
		if(0<=curx && curx<n && 0<=cury &&cury<m)
		{
			if(grid[curx][cury])
			dfs(curx,cury);
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin>>t;
	while(t--)
	{
		int count123(0);
		memset(visited,0,sizeof(visited));
		memset(grid,0,sizeof(grid));
		cin>>m>>n>>k;
		for(int j=0; j<k; j++)
		{
			int x,y;
			cin>>x>>y;
			grid[y][x]=1;
		}
		for(int j=0; j<n; j++)
		{
			for(int k=0; k<m; k++)
			{
				if(grid[j][k]&& visited[j][k]==false)
				{
					dfs(j,k);
					count123++;
				}
			}
		}
			cout<<count123<<"\n";
	}
}


