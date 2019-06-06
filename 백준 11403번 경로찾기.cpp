#include<iostream>
#include<queue>
#include<vector>
#include<functional>
using namespace std;

int n;
int grid[101][101];
bool visited[101][101];

void bfs(int start)
{
	queue<int> q;
	q.push(start);
	while(!q.empty())
	{
		int u(q.front());
		q.pop();
		for(int i=0; i<n; i++)
		{
			if(grid[u][i]&& visited[start][i]==false)
			{
				visited[start][i]=true;
					q.push(i);
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
		for(int j=0; j<n; j++)
			cin>>grid[i][j];
	
	for(int i=0; i<n; i++)
	bfs(i); 
			
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		cout<<visited[i][j]<<" ";
		cout<<"\n";
	}
	
}
