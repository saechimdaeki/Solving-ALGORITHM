#include<iostream>
#include<queue>
#include<cstring>
using namespace std; 
int grid[101];
int dist[101];
int n,m;
queue<int> q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		int a,b;
		cin>>a>>b;
		grid[a]=b;
	}
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		grid[a]=b;
	}
	memset(dist,-1,sizeof(dist));
	dist[1]=0;
	q.push(1);
	while(!q.empty())
	{
		int cur(q.front());
		q.pop();
		for(int i=1; i<=6; i++)
		{
			int nextpoint(cur+i);
			if(nextpoint>100)
			continue;
			if(grid[nextpoint]!=0)
			nextpoint=grid[nextpoint];
			if(dist[nextpoint]==-1)
			{
				dist[nextpoint]=dist[cur]+1;
				q.push(nextpoint);	
			}	
		}
	}
	cout<<dist[100];
	
	
}
