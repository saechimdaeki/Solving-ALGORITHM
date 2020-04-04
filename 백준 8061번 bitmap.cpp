#include<iostream>
#include<algorithm>
#include<cmath>
#include<queue>
#include<vector>
#include<tuple>
#define endl '\n'
using namespace std;
int n,m;
int grid[182][182];
int oneposition[182][182];
bool visited[182][182];
typedef struct{
	int x, y;
}dir;
dir quad[4]={{0,1},{0,-1},{-1,0},{1,0}};
queue<pair<pair<int,int>,int>> q;
int x,y,z;
void bfs()
{
	while(!q.empty())
	{
		x=q.front().first.first;
		y=q.front().first.second;
		z=q.front().second;
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y),nextz(z+1);	
		//	cout<<nextx<<' '<<nexty<<' '<<nextz<<endl;
			if(nextx<0 || nextx>=n ||nexty<0 ||nexty>=m ||nextz>=oneposition[nextx][nexty])
			{
				continue;
			}
			oneposition[nextx][nexty]=nextz;
			q.push({{nextx,nexty},nextz});
	

		}
	}
	
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		for(int j=0; j<m; j++)
		{
			grid[i][j]=s[j]-'0';
			if(grid[i][j]==1)
			{
				oneposition[i][j]=0;
				q.push({{i,j},0});
			}else
			oneposition[i][j]=2e9;	
		}
	}	
	bfs();
		

	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			cout<<oneposition[i][j]<<' ';
		}
		cout<<endl;
	}
}
