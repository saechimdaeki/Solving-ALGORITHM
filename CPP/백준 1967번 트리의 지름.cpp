#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;
int n,answer,startpoint(1);
struct edge{
	int to,cost;
	edge(int to , int cost):to(to),cost(cost){}
};
vector<edge> v[10001];
bool visited[10001];
int distan[10001];
queue<int> q;
void bfs(int v1)
{
	 q.push(v1);
	 visited[v1]=true;
	 while(!q.empty())
	 {
	 	int now(q.front());
	 	q.pop();
	 	for(int i=0; i<v[now].size(); i++)
	 	{
	 		edge &e=v[now][i];
	 		if(!visited[e.to])
	 		{
	 			distan[e.to]=distan[now]+e.cost;
				q.push(e.to);
				visited[e.to]=true; 	
			}
		 }
	 }
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n-1; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		v[a].push_back(edge(b,c));
		v[b].push_back(edge(a,c));
	}
	bfs(1);
	
	for(int i=2; i<=n; i++)
		if(distan[i]>distan[startpoint])
			startpoint=i;
	memset(distan,0,sizeof(distan));
	memset(visited,false,sizeof(visited));		
	bfs(startpoint);
	answer=distan[1];
	for(int i=2; i<=n; i++)
	answer=max(answer,distan[i]);
	cout<<answer;		
}
