#include<iostream>
using namespace std;
int grid[33][33];
long long dp[33][33][3];
int n;
long long ans;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>grid[i][j];
	dp[0][1][0]=1;
	//x low y col
	for(int x=0; x<n; x++)
	{
		for(int y=0; y<n; y++)
		{
			if(grid[x][y+1]==0) //-  
			dp[x][y+1][0]+=dp[x][y][0]+dp[x][y][2];//'-' or '\'
			if(grid[x+1][y]==0) // |
			dp[x+1][y][1]+=dp[x][y][1]+dp[x][y][2]; // '|' or '\'
			if(grid[x+1][y+1]==0 && grid[x+1][y]==0 && grid[x][y+1]==0) //'\'
			dp[x+1][y+1][2]+=dp[x][y][0]+dp[x][y][1]+dp[x][y][2]; // all 
		}
	}
	for(int i=0; i<3; i++)
	ans+=dp[n-1][n-1][i];
	cout<<ans;	
}
