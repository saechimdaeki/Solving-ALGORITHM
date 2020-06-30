#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
using namespace std;
bool visited[100001];
vector<int> grid[100001];
int susoon[100001];
int parent[100001];
queue<int> q;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n-1; i++)
	{
		int a,b;
		cin>>a>>b;
		a--;b--;
		grid[a].push_back(b);
		grid[b].push_back(a);
	}
	for(int i=0; i<n; i++)
	{
		cin>>susoon[i];
		susoon[i]--;
	}

	int qsize(1);
	q.push(0);
	visited[0]=true;
	for(int i=0; i<n; i++)
	{
		if(q.empty())
		{
			cout<<0;
			return 0;
		}
		int bts(q.front());
		q.pop();
		if(bts != susoon[i])
		{
			cout<<0;
			return 0;
		}
		int cnt(0);
		for(auto j:grid[bts])
		{
			if(!visited[j])
			{
				parent[j]=bts;
				cnt++;
			}
		}
		for(int j=0; j<cnt; j++)
		{
			if(qsize+j>=n ||parent[susoon[qsize+j]]!=bts)
			{
				cout<<0;
				return 0;
			}
			q.push(susoon[qsize+j]);
			visited[susoon[qsize+j]]=true;
		}
		qsize+=cnt;
	}
	cout<<1;
	
}
