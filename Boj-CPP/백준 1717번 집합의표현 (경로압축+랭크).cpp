#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n,m;
int parent[1000001];
int lank[1000001];
int find(int x)
{
	if(x==parent[x])
	return x;
	else
	return parent[x]=find(parent[x]);
}
void unio_n(int x, int y)
{
	x=find(x);
	y=find(y);
	if(x==y)
	return;
	if(lank[x]<lank[y])
	swap(x,y);
	parent[y]=x;
	if(lank[x]==lank[y])
	lank[x]=lank[y]+1;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<=n; i++)
	{
		parent[i]=i;
		lank[i]=0;
	}
	for(int i=0; i<m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		if(a==0)
		unio_n(b,c);
		else{
			b=find(b);
			c=find(c);
			if(b==c)
			cout<<"YES"<<endl;
			else
			cout<<"NO"<<endl;
		}
	}
}
