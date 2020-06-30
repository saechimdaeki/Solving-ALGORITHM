#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int n,m;
int parent[201];

int findparent(int n1)
{
	if(parent[n1]==n1)
	return n1;
	else
	return parent[n1]=findparent(parent[n1]); 
}
void unionparent(int n1,int n2)
{
	int p1(findparent(n1));
	int p2(findparent(n2));
	parent[p2]=p1;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=1; i<=n; i++)
	parent[i]=i;
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=n; j++)
		{	
			int trip;
			cin>>trip;		
			if(trip==1)
			{
				if(findparent(i)!=findparent(j))
				unionparent(i,j);
			}
		}
	}
	int bts;
	cin>>bts;
	bts=findparent(bts);
	for(int i=1; i<m; i++)
	{
		int trip;
		cin>>trip;
		if(bts!=findparent(trip))
		{
			cout<<"NO"<<"\n";
			goto z;
		}
	}
	cout<<"YES"<<"\n";
	z:
		return 0;
}
