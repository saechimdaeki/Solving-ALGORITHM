#include<cstring>
#include<iostream>
#include<queue>
#include<algorithm>
#define endl '\n'
#include<vector>
using namespace std;
/*  인접리스트로 풀어보기*/ 
bool visited[1001];
vector<int> vec[1001];
int n, m,v;

void dfs(int v1)
{
	cout<<v1<<' ';
	visited[v1]=true;
	for(int a:vec[v1])
	{
		if(!visited[a])
		dfs(a);
	}
}
queue<int> q;
void bfs(int v1)
{
	
	q.push(v1);
	visited[v1]=true;
	while(!q.empty())
	{
		int now=q.front();
		cout<<now<<' ';
		q.pop();
		for(int a:vec[now])
		{
			if(!visited[a])
			{
				q.push(a);
				visited[a]=true;
			}
		}
		
	}
}



int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m>>v;
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		vec[a].push_back(b);
		vec[b].push_back(a);
	}
	for(int i=1; i<=n; i++)
	sort(vec[i].begin(),vec[i].end());
	dfs(v);
	memset(visited,false,sizeof(visited));
	cout<<endl;
	bfs(v);
	
}
