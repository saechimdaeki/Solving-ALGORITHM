#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
using namespace std;
int n,m,k;
int grid[1001][1001],state[1001][1001][11];
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
void bfs(int x,int y,int z)
{
	queue<tuple<int, int, int > > q;
	state[x][y][z]=1;
	q.push(make_tuple(x,y,z));
	while(!q.empty())
	{
		tie(x,y,z)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x);
			int nexty(y+quad[i].y);
			if(nextx<0 || nextx>=n || nexty<0 ||nexty>=m)
				continue;
			if(grid[nextx][nexty]==0 && state[nextx][nexty][z]==0)
			{
				state[nextx][nexty][z]=state[x][y][z]+1;
				q.push(make_tuple(nextx,nexty,z));	
			}
			if(z+1<=k && grid[nextx][nexty]==1 &&state[nextx][nexty][z+1]==0)
			{
				state[nextx][nexty][z+1]=state[x][y][z]+1;
				q.push(make_tuple(nextx,nexty,z+1));
				}	
		}
	}
	
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m>>k;
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		for(int j=0; j<m; j++)
		grid[i][j]=s[j]-'0';	
	}
	bfs(0,0,0);
	int answer(-1);
	for(int i=0; i<=k; i++)
	{
		if(state[n-1][m-1][i]==0)
		continue;
		if(answer==-1)
		answer=state[n-1][m-1][i];
		else if(answer>state[n-1][m-1][i])
		answer=state[n-1][m-1][i];
	}
	cout<<answer;
}
