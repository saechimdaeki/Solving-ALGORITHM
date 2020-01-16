#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<cstring>
#define endl '\n'
using namespace std;
int n;
int cnt;
typedef struct {
	int x, y;
}dir;
dir quad[4]={{1,0},{-1,0},{0,1},{0,-1}};

string grid[101];
bool visited[101][101];

void bfs(int x, int y, bool color)
{
	char collect(grid[x][y]);
	queue<pair<int, int > > q;
	q.push(make_pair(x,y));
	visited[x][y]=true;
	while(!q.empty())
	{
		int nowx=q.front().first;
		int nowy=q.front().second;
			q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(nowx+quad[i].x);
			int nexty(nowy+quad[i].y);
			if(0<=nextx && nextx<n && 0<=nexty && nexty <n)
			{
				if(color==false)
				{
					if(grid[nextx][nexty]==collect && visited[nextx][nexty]==false)
					{
						visited[nextx][nexty]=true;
						q.push(make_pair(nextx,nexty));
					}
				}else if(color==true)
				{
					if(collect=='R'|| collect=='G')
					{
						if((grid[nextx][nexty]=='R'|| grid[nextx][nexty]=='G')&& visited[nextx][nexty]==false)
						{
							visited[nextx][nexty]=true;
							q.push(make_pair(nextx,nexty));	
						}	
					}else if(collect=='B')
					{
						if(visited[nextx][nexty]==false && (grid[nextx][nexty]==collect))
						{
							visited[nextx][nexty]=true;
							q.push(make_pair(nextx,nexty));
						}
					}	
				}
			}
		}
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>grid[i];	
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(visited[i][j]==false)
			{
				bfs(i,j,false);
				cnt++;
			}
		}
	}
	cout<<cnt<<' ';
	memset(visited,false,sizeof(visited));
	cnt=0;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(visited[i][j]==false)
			{
				bfs(i,j,true);
				cnt++;
			}
		}
	}
	cout<<cnt;
}
