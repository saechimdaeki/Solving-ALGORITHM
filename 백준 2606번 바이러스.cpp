#include<iostream>
#include<algorithm>
#include<queue>
#define endl '\n'
using namespace std;
int n,m;
int count123;
int grid[101][101];
bool visited[101];
queue<int> q;
void bfs(int v1)
{
	visited[v1]=true;
	q.push(v1);
	while(!q.empty())
	{
		int now=q.front();
		q.pop();
		for(int i=1; i<=n; i++)
		{
			if(visited[i]==false&& grid[now][i]==1)
			{
				q.push(i);
				visited[i]=true;
				count123++;
			}
		}
	}
}	


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		grid[a][b]=grid[b][a]=1;		
	}
	bfs(1);
	cout<<count123;	
}
