#include<iostream>
using namespace std;

int dp[61][61];
int allyak[31];
int main()
{
	int n;
	dp[1][1]=1;
	allyak[1]=1;
	for(int i=2; i<=60; i++)
	{
		int bts=i-1;
		for(int j=bts/3; j<=i; j++)
		{
			dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			if(j<=i/2)
			allyak[i]+=dp[i][j];
		}
	}
	while(scanf("%d",&n),n!=0)
	printf("%lld",allyak[2*n]); 
}
