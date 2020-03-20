#include<iostream>
#include<algorithm>
using namespace std;
int arr[1001];
int dp[1001];
int n; 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
	cin>>arr[i];
	for(int i=1; i<=n; i++)
	{
		dp[i]=1;
		for(int j=1; j<=i; j++)
			if(arr[j]>arr[i]&& dp[i]<dp[j]+1)
				dp[i]=dp[j]+1;
				
	}
	cout<<*max_element(dp,dp+n+1);
}
