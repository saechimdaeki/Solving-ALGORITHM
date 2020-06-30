#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#define endl '\n'

using namespace std;
int V,E,K;
int dist[20001]; 
typedef pair<int,int> pi;
class node{
	public:
		int point;
		int value;
};

vector<node> nodev[300001];
 

void dijkstra(int n1)
{
	priority_queue<pi> pq;
	pq.push({0,n1});
	while(!pq.empty())
	{
		int current(pq.top().second);
		int distance(-pq.top().first);
		pq.pop();
		if(dist[current]<distance)
			continue;
		for(int i=0; i<(int)nodev[current].size(); i++)
		{
			int next(dist[current]+nodev[current][i].value);
			int nextdistance(dist[nodev[current][i].point]);
			if(nextdistance > next )
			{
				dist[nodev[current][i].point]=next;
				pq.push({-next, nodev[current][i].point});
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>V>>E>>K;
	for(int i=0; i<E;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		nodev[u].push_back(node{v,w});
	}
	for(int i=0; i<=V; i++)
	dist[i]=2e9+1;
	
	
	
	dist[K]=0;
	
	dijkstra(K);
	for(int i=1; i<=V; i++)
	{
		dist[i]!=2e9+1 ? cout<<dist[i]<<endl : cout<<"INF"<<endl; 
	}
	
	
}
