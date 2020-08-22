#include<iostream>
using namespace std;
int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin>>t;
	for(int i=0; i<t; i++)
	{
		cin>>n>>m;
		for(int j=0; j<m; j++)
		{
			int node1,node2;
			cin>>node1>>node2;
		}
		cout<<n-1<<"\n";
	}
}
