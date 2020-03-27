#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<int> after_dfs;
vector<int> grid[100001];
vector<int> forcmp;
vector<int> susoon;
bool visited[100001];
int n;
void dfs(int x)
{
	if(visited[x])
	return;
	after_dfs.push_back(x);
	visited[x]=true;
	for(auto i:grid[x])
		dfs(i);
}
bool cmp(int n1 ,int n2)
{
	return susoon[n1]<susoon[n2];
 } 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n-1; i++)
	{
		int a,b;
		cin>>a>>b;
		grid[a-1].push_back(b-1);
		grid[b-1].push_back(a-1);
	}
	susoon.resize(n); forcmp.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>forcmp[i];
		forcmp[i]--;
		susoon[forcmp[i]]=i;
	}
	for(int i=0;i<n; i++)
	sort(grid[i].begin(),grid[i].end(),cmp);
	dfs(0);

	if(after_dfs==forcmp)
	cout<<1;
	else
	cout<<0;
	
}
