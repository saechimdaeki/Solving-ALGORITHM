#include<iostream>
#include<algorithm>
using namespace std;

int sozoo[10001];
int dp[10001];
int n;

int grape()
{
	dp[1]=sozoo[1];
	dp[2]=sozoo[1]+sozoo[2];
	if(n==1)
		return dp[1];
	else if(n==2)
		return dp[2];
	else
	{
		for(int i=3; i<=n; i++)
		{
			int jyp=max(dp[i-2]+sozoo[i],dp[i-3]+sozoo[i-1]+sozoo[i]);
			dp[i]=max(dp[i-1],jyp);
		}
		return dp[n];
	}
}

int main()
{
	
	cin>>n;
	for(int i=1; i<=n; i++)
		cin>>sozoo[i];
		
	cout<<grape()<<endl;

	
} 
