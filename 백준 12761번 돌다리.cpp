#include<iostream>
#include<queue>
#define endl '\n'
using namespace std;
bool visited[100001];
int a,b,n,m,cnt;
queue<pair<int, int> > q;

void bfs(int n1)
{

	q.push(make_pair(n1,0));
	visited[n1]=true;
	while(!q.empty())
	{
		int now(q.front().first);
		cnt=q.front().second;
		q.pop();
		if(now==m)
		return;
		if(now+1<100001 &&visited[now+1]==false)
		{
			visited[now+1]=true;
			q.push(make_pair(now+1,cnt+1));	
		}	
		if(now-1>=0 && visited[now-1]==false)
		{
			visited[now-1]=true;
			q.push(make_pair(now-1,cnt+1));
		}
		if(now+a<100001 && visited[now+a]==false)
		{
			visited[now+a]=true;
			q.push(make_pair(now+a,cnt+1));
		}
		if(now-a>=0 && visited[now-a]==false)
		{
			visited[now-a]=true;
			q.push(make_pair(now-a,cnt+1));
		}
		if(now+b<100001 && visited[now+b]==false)
		{
			visited[now+b]=true;
			q.push(make_pair(now+b,cnt+1));
		}
		if(now-b>=0 && visited[now-b]==false)
		{
			visited[now-b]=true;
			q.push(make_pair(now-b,cnt+1));
		}
		if(now*a<100001 && visited[now*a]==false)
		{
			visited[now*a]=true;
			q.push(make_pair(now*a,cnt+1));
		}
		if(now*b<100001 && visited[now*b]==false)
		{
			visited[now*b]=true;
			q.push(make_pair(now*b,cnt+1));
		}
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>n>>m;
	bfs(n);
	cout<<cnt;
}
