#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
int n,m;
vector<int> v[10001],answer;

bool visited[10001];
int hack;
void bfs(int num)
{
	queue<int > q;
	q.push(num);
	visited[num]=true;
	int cnt(0);
	while(!q.empty())
	{
		int cur(q.front());
		q.pop();
		for(auto i:v[cur])
		{
			if(visited[i])
			continue;
			q.push(i);
			visited[i]=true;
			cnt++;
		}
	}
	if(hack<cnt)
	{
		hack=cnt;
		answer.clear();
		answer.push_back(num);
	}else if(hack==cnt)
	answer.push_back(num);
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
		v[b].push_back(a);
	}
	for(int i=1; i<=n; i++)
	{
		memset(visited,false,sizeof(visited));
		bfs(i);
	}
	sort(answer.begin(),answer.end());
	for(auto i:answer)
	cout<<i<<' ';
}
