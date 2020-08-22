#include<iostream>
#include<cstring> 
using namespace std;
int dp[31][31];

int bts(int n, int k)
{
	if(n==k || k==0)
		return 1;
	int &result=dp[n][k];
	if(result !=-1)
		return result;
	result=bts(n-1,k-1)+bts(n-1,k);
	return result;
}

int main()
{
	int n,k;
	cin>>n>>k;
	memset(dp,-1,sizeof(dp));
	cout<<bts(n-1,k-1);
	
}
