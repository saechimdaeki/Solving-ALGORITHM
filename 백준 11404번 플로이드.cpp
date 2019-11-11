#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
#define endl '\n'
using namespace std;
int n,m;
int grid[101][101];
bool visited[101][101];

void floyd(int s)
{
	for(int i=1; i<=s; i++)
	{
		for(int j=1; j<=s; j++)
		{
			for(int k=1; k<=s; k++)
			{
				if(grid[i][k]+grid[j][i]<grid[j][k])
					grid[j][k]=grid[i][k]+grid[j][i];
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=n; j++)
		if(i==j)
		;
		else
			grid[i][j]=123456789;
	}
	for(int i=0; i<m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		if(grid[a][b]>c)
		grid[a][b]=c;		
	}
	floyd(n);
	for(int i=1; i<=n; i++)
	{
		for(int j=1; j<=n; j++)
		{
			if(grid[i][j]==123456789)
			cout<<"0 ";
			else
			cout<<grid[i][j]<<' ';
		}
		cout<<endl;
	}
}

