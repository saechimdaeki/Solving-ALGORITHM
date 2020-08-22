#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;


int getparent(int parent[],int x)//부모 노드 찾는 함수 
{
   if(parent[x]==x)
   return x;
   return parent[x]=getparent(parent,parent[x]);
}
//두 부모노드 합치는함수 
int unionparent(int parent[],int a, int b)
{
   a=getparent(parent,a);
   b=getparent(parent,b);
   if(a<b)
   parent[b]=a;
   else
   parent[a]=b;
 } 
 
 //같은 부모가지는지 확인 
int findparent(int parent[],int a,int b)
{
   a=getparent(parent,a);
   b=getparent(parent,b);
   if(a==b)
   {
      return 1;
   }
   else
   {
      return 0;   
   }
}
//간선클래스 
class Edge{
	public:
		int node[2];
		int distance;
		Edge(int a, int b, int distance)
		{
			this->node[0]=a;
			this->node[1]=b;
			this->distance=distance;
		}
		bool operator <(Edge &edge){
			return this->distance <edge.distance;
		}
};


int main()
{
   int n=7;
   int m=11;
   vector<Edge> v;
   v.push_back(Edge(1,7,12));
   v.push_back(Edge(1,4,28));
   v.push_back(Edge(1,2,67));
   v.push_back(Edge(1,5,17));
   v.push_back(Edge(2,4,24));
   v.push_back(Edge(2,5,62));
   v.push_back(Edge(3,5,20));
   v.push_back(Edge(3,6,37));
   v.push_back(Edge(4,7,13));
   v.push_back(Edge(5,6,45));
   v.push_back(Edge(5,7,73));
   
   sort(v.begin(),v.end());
   
   int parent[n];
   for(int i=0; i<n; i++)
   parent[i]=i;
	int sum(0);
	for(int i=0; i<v.size(); i++)
	{
		if(!findparent(parent,v[i].node[0]-1,v[i].node[1]-1))//사이클 발생하지않는경우포함 
		sum+=v[i].distance;
		unionparent(parent,v[i].node[0]-1,v[i].node[1]-1);
	}
	cout<<sum;
}
