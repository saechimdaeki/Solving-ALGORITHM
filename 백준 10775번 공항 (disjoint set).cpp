#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
#include<cstdio>
using namespace std;

int parent[100001];
int g,p,count123,empty;
int findset(int n)
{
	if(parent[n]==n)
	return n;
	return parent[n]=findset(parent[n]);
}

void union_set(int n1, int n2)
{
	int x(findset(n1));
	int y(findset(n2));
	
	if(x>y)
	parent[x]=y;
	else
	{
		parent[y]=x;
		if(x==y)
		parent[y]=parent[y]+1;	
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin>>g>>p;
	for(int i=1; i<=g; i++)
	parent[i]=i;
	for(int i=0; i<p; i++)
	{
		int a;
		cin>>a;
		 empty=findset(a);
		if(empty==0)
		goto z;
		else{
			count123++;
			union_set(empty,empty-1);
		}
	}
	z:
	cout<<count123;
}
 
