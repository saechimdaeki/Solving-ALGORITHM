#include<iostream>
#include<algorithm>
using namespace std;
int arr[1001][3];
int dp[1001][3];
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
		for (int j=0; j<3; j++)
			cin>>arr[i][j];
	
	int ans=1e9+1;	
	/* 첫집과 마지막집이 이웃이니까 dp를 3번수행해서 구해야함. */
	for(int k=0; k<=2; k++)
	{
		for(int j=0; j<=2; j++)
		{
			if(j==k)
			dp[1][j]=arr[1][j];
			else
			dp[1][j]=1e9+1;
		}
	for(int i=2; i<=n; i++)
	{
		dp[i][0]=min(dp[i-1][1],dp[i-1][2])+arr[i][0];
		dp[i][1]=min(dp[i-1][0],dp[i-1][2])+arr[i][1];
		dp[i][2]=min(dp[i-1][1],dp[i-1][0])+arr[i][2];
	}	
	for(int j=0; j<=2; j++)
	{
		if (j==k)
		continue;
		ans=min(ans,dp[n][j]);
	}	
}
	cout<<ans;

}
