#include<iostream>
#include<functional>
#include<vector>
#include<algorithm>
using namespace std;
int n,m,mst;
int parent[1001];
class Edge{
	public:
		int u,v,distance;
		
		Edge(int u, int v, int distance)
		{
			this->u=u;
			this->v=v;
			this->distance=distance;
		}
		bool operator <(Edge &e)
		{
			return distance<e.distance;
		}
};
int getparent(int n1)
{
	if(n1==parent[n1])
	return n1;
	else
	return parent[n1]=getparent(parent[n1]);
}
int unionparent(int n1, int n2)
{
	n1=getparent(n1);
	n2=getparent(n2);
	if(n1<n2)
	parent[n2]=n1;
	else
	parent[n1]=n2;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	vector<Edge> e;
	cin>>n>>m;
	for(int i=0; i<m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		e.push_back(Edge(a,b,c));
	}
	sort(e.begin(),e.end());
	
	for(int i=1; i<=n; i++)
	parent[i]=i;
	for(int i=0; i<e.size(); i++)
	{
		Edge kruskal=e[i];
		if(getparent(kruskal.u)!=getparent(kruskal.v))
		{
			mst+=kruskal.distance;
			unionparent(kruskal.u,kruskal.v);
		}
	}
	cout<<mst;
}

