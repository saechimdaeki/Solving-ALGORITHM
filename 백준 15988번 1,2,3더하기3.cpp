#include<iostream>
#define endl '\n'
using namespace std;
const long long abcd=1000000009;
long long dp[1000001];
int t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
		dp[0]=1;
	for(int i=1; i<=1000001; i++)
	{
		if(i-1>=0)
			dp[i]+=dp[i-1];
		if(i-2>=0)
			dp[i]+=dp[i-2];
		if(i-3>=0)
			dp[i]+=dp[i-3];
		dp[i]%=abcd; 
	}
	cin>>t;
	for(int i=0; i<t;i++)
	{
		int n;
		cin>>n;
		cout<<dp[n]<<endl;
	}
}
