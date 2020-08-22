#include<iostream>
#include<algorithm>
#include<queue>
#define endl '\n'
using namespace std;
int n;
vector<int> tree[100001];
bool visited[100001];
int parent[100001];
queue<int> q;
void findboomo_bfs(int vertex)
{
	visited[vertex]=true;
	q.push(vertex);
	while(!q.empty())
	{
		int now(q.front());
		q.pop();
		for(int i=0; i<tree[now].size();i++)
		{
		if(visited[tree[now][i]]==false)
		{
			visited[tree[now][i]]=true;
			parent[tree[now][i]]=now;
			q.push(tree[now][i]);
		}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<n; i++)
	{
		int a,b;
		cin>>a>>b;
		tree[a].push_back(b);
		tree[b].push_back(a);	
	}
	findboomo_bfs(1);
	for(int i=2; i<=n; i++)
	cout<<parent[i]<<endl;
} 
