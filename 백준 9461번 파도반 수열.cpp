#include<iostream>
using namespace std;
long long dp[100];
	
int main()
{
	dp[1]=1;
	dp[2]=1;
	dp[3]=1;
	dp[4]=2;
	dp[5]=2;
	int n;
	cin>>n;
	for(int i=6; i<=100;i++)
	{
		dp[i]=dp[i-1]+dp[i-5];
	}
	for(int i=0; i<n; i++)
	{
		int n2;
		cin>>n2;
		cout<<dp[n2]<<endl; 

	}
}
