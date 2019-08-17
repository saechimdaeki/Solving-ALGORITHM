#include<iostream>
#include<algorithm>
using namespace std;
int grid[1001][1001];
int dynamic[1001][1001];
int n,m;
int ans;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=m; j++)
		cin>>grid[i][j];
	}
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=m; j++)
		{
		
			ans=(max(max(dynamic[i-1][j-1],dynamic[i-1][j]),dynamic[i][j-1]));	
			dynamic[i][j]=ans+grid[i][j];
		}					
	}
	cout<<dynamic[n][m];	
}
