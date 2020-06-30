#include<iostream>
#include<algorithm>
using namespace std;
bool check[9];
int a[9];
int n,m;
void recur(int index,int n, int m)
{
	if(index==m)
	{
		for(int i=0; i<m; i++)
		{
			cout<<a[i]<<" ";
		}
		cout<<"\n";
		return;	
	}
	
	for(int i=1; i<=n; i++)
	{
		if(check[i]==true)
		continue;
		else
		check[i]=true;
		a[index]=i;
		recur(index+1,n,m);
		check[i]=false;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	recur(0,n,m);
}
