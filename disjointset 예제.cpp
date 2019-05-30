#include<iostream>

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

int main()
{
	int parent[11];
	for(int i=1; i<=10; i++)
	parent[i]=i;
	
	unionparent(parent,1,2);
	unionparent(parent,2,3);
	unionparent(parent,3,4);
	unionparent(parent,5,6);
	unionparent(parent,7,8);
	cout<<"1과 5는 연결되어있을까? "<<findparent(parent,1,5)<<"\n";
	cout<<"1과 6을 연결해볼게연 "<<"\n";
	unionparent(parent,1,6);
	cout<<"1과 5는 연결되어있을까? "<<findparent(parent,1,5)<<"\n";
}
