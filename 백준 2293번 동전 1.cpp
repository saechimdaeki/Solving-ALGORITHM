#include<iostream>
using namespace std;
int n[101];//µ¿Àü 
int dp[100001];//µ·°¡Ä¡ 
int main()
{
	dp[0]=1;
	int N,K;
	cin>>N>>K;
	
	for(int i=0; i<N; i++)
	{
		cin>>n[i];
		for(int j=n[i]; j<=K; j++)
		{
			dp[j]+=dp[j-n[i]];		
		}
	}
	cout<<dp[K];
}
