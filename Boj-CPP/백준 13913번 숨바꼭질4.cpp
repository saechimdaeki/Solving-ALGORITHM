#include<iostream>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;
int n,k,timer;
bool visited[100001];
int from[100001];
stack<int> s;
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
		{
			int tmp(subin_which);
			while(tmp!=subin)
			{
				s.push(tmp);
				tmp=from[tmp];	
			}
			s.push(subin);
			return;
		}
		if(subin_which*2<100001 && !visited[subin_which*2])
		{
			q.push({subin_which*2,timer+1});
			visited[subin_which*2]=true;
			from[subin_which*2]=subin_which;
		}
		if(subin_which+1<100001 &&!visited[subin_which+1])
		{
			q.push({subin_which+1,timer+1});
			visited[subin_which+1]=true;
			from[subin_which+1]=subin_which;
		}
		if(subin_which-1>=0 && !visited[subin_which-1])
		{
			q.push({subin_which-1,timer+1});
			visited[subin_which-1]=true;
			from[subin_which-1]=subin_which;
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	bfs(n,k);
	cout<<timer<<endl;
	while(!s.empty())
	{
		cout<<s.top()<<' ';
		s.pop();
	}
}
