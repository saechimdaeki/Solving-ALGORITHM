#include<iostream>
#include<algorithm>
#include<queue>
#define endl '\n'
using namespace std;
int n;
vector<int> tree[100001];
bool visited[100001];
int parent[100001];
void findboomo_dfs(int vertex)
{
	visited[vertex]=true;
	for(int i=0; i<tree[vertex].size(); i++)
	{
		int nextvertex(tree[vertex][i]);
		if(visited[nextvertex]==false)
		{
			parent[nextvertex]=vertex;
			findboomo_dfs(nextvertex);
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
	findboomo_dfs(1);
	for(int i=2; i<=n; i++)
	cout<<parent[i]<<endl;
} 
