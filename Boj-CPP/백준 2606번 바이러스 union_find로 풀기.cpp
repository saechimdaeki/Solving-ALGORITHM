#include<iostream>
#include<algorithm>
using namespace std;
int n,m,answer;
int parent[101];
/* Union_find·Î Ç®±â  */
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
	if(x!=y)
	parent[y]=x;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=1; i<=n; i++)
	{
		parent[i]=i;
	}
	for(int i=0; i<m; i++)
	{
		int a,b;
		cin>>a>>b;
		unio_n(a,b);
	}
	for(int i=2; i<=n; i++)
	{
		if(find(1)==find(i))
		answer++;
	}
	cout<<answer;
}

