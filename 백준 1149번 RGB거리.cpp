#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
int arr[1001][3];
int dp[1001][3];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
	{
		for(int j=0; j<3; j++)
		cin>>arr[i][j];
	}
	for(int i=1; i<=n; i++)
	{
		dp[i][0]=min(dp[i-1][1],dp[i-1][2])+arr[i][0];
		dp[i][1]=min(dp[i-1][0],dp[i-1][2])+arr[i][1];
		dp[i][2]=min(dp[i-1][0],dp[i-1][1])+arr[i][2];
	}
	cout<<min(min(dp[n][0],dp[n][1]),dp[n][2]);
}
