#include<iostream>
#include<functional>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;
int n,m,cnt;
int grid[1001][1001];
bool visited[1001];

void bfs(int s)
{
	cnt++;
	queue<int> q;
	q.push(s);
	visited[s]=true;
	while(!q.empty())
	{
		int u=q.front();
		q.pop();
		for(int i=1; i<=n; i++)
		{
			if(grid[u][i]&& visited[i]==false)
			{
				visited[i]=true;
				q.push(i);
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=1; i<=m; i++)
	{
		int a,b;
		cin>>a>>b;
		grid[a][b]=1;
		grid[b][a]=1;
	}
	for(int i=1; i<=n; i++)
	{
		if(visited[i]==false)
		{
		bfs(i);
		
		}
	}
	cout<<cnt;
	
}
