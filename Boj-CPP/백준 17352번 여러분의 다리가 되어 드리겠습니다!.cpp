#include<iostream>
#include<algorithm>
using namespace std;
int n;
int parent[300001];
int arr[2];
int answer;
int findset(int n1)
{
	if(parent[n1]==n1)
	return n1;
	return parent[n1]=findset(parent[n1]);
}
void unionset(int n1, int n2)
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
void init(int n1)
{
	for(int i=1; i<=n; i++)
	parent[i]=i;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	init(n);
	for(int i=0; i<n-2; i++)
	{
		int x1,x2;
		cin>>x1>>x2;
		unionset(x1,x2);	
	}
	for(int i=1; i<=n; i++)
	{
		if(parent[i]==i)
			arr[answer++]=i;
	}
	cout<<arr[0]<<" "<<arr[1];	
}
 
