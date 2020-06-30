#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
int n,k,timer;
bool visited[100001];
void bfs(int subin, int brother)
{
	queue<pair<int, int> > q;
	q.push({subin,0});
	visited[subin]=true;
	while(!q.empty())
	{
		int subin_which(q.front().first);
		timer=q.front().second;
		q.pop();
		if(subin_which==brother)
		return;
		if(subin_which*2<100001 && !visited[subin_which*2])
		{
			q.push({subin_which*2,timer+1});
			visited[subin_which*2]=true;
		}
		if(subin_which+1<100001 &&!visited[subin_which+1])
		{
			q.push({subin_which+1,timer+1});
			visited[subin_which+1]=true;
		}
		if(subin_which-1>=0 && !visited[subin_which-1])
		{
			q.push({subin_which-1,timer+1});
			visited[subin_which-1]=true;
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	bfs(n,k);
	cout<<timer;
}
