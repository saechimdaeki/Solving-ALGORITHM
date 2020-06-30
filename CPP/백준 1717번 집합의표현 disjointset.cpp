#include<iostream>
#include<algorithm>
using namespace std;
int n,m;
int arr[1000001];

int findparent(int n1)
{
	if(arr[n1]<0)
	return n1;
	arr[n1]=findparent(arr[n1]);
	return arr[n1];
}

void unionparent(int n1, int n2)
{
	int p1(findparent(n1));
	int p2(findparent(n2));
	if(p1==p2)
	return;
	arr[p2]=p1;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<=n; i++)
	{
		arr[i]=-1;
	}
	for(int i=1; i<=m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		if(a==0)
		{
			unionparent(b,c);
		}
		else
		{
			int check1(findparent(b));
			int check2(findparent(c));
			if(check1==check2)
			cout<<"YES";
			else
			cout<<"NO";
			cout<<"\n";
		}
	}
}
