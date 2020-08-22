#include<iostream>
#include<algorithm>
using namespace std;
int dp[1001];
int arr[10001];

int main()
{
	int N;
	cin>>N;
	for(int i=1; i<=N;i++)
	
		cin>>arr[i];
		
		for(int i=1; i<=N; i++)
		{
			for(int a=1; a<=i; a++)
			dp[i]=max(dp[i],dp[i-a]+arr[a]);
		}
	
	

	cout<<dp[N];
}
