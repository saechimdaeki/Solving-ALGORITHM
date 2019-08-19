#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<functional>
using namespace std;
int grid[101][101];
int depth[101];
vector<int> v[101];
int n,m;
int x,y;
queue<int > q;
int bfs(int x1,int y1)
{
	q.push(x1);
	while(!q.empty())
	{
		int now=q.front();
		q.pop();
		if(now==y1)
		return depth[y1];
		
		for(int i=0; i<v[now].size(); i++)
		{
			int next=v[now][i];
			if(depth[next]==0)
			{
				q.push(next);
				depth[next]=depth[now]+1;
			}
		}
	}
	return -1;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cin>>x>>y;
	cin>>m;
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	cout<<bfs(x,y);
	
	
}
