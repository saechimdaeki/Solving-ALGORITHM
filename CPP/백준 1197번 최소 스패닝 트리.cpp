#include<iostream>
#include<functional>
#include<vector>
#include<algorithm>
using namespace std;
int parent[10001];
int V,E,mst;
class Edge{
	public:
	int u,v,distance;
	Edge(int u,int v, int distance)
	{
		this->u=u;
		this->v=v;
		this->distance=distance;
	}
	bool operator<(Edge &e)
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
	cin>>V>>E;
	vector<Edge> kruskal;
	for(int i=0; i<E; i++)
	{
		int v1,v2,v3;
		cin>>v1>>v2>>v3;
		kruskal.push_back(Edge(v1,v2,v3));
	}
	sort(kruskal.begin(),kruskal.end());
	for(int i=0; i<V; i++)
		parent[i]=i;	
	for(int i=0; i<kruskal.size(); i++)
	{
		Edge cl=kruskal[i];
		if(getparent(cl.u)!=getparent(cl.v))
		{
			mst+=cl.distance;
			unionparent(cl.u,cl.v);
		}
	}
	cout<<mst;
}


