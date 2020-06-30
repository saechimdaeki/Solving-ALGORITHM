#include<iostream>
#include<algorithm>
using namespace std;

int divide=10007;
int dp[10][1001];

int n;
int jungin()
{
	for(int i=0; i<10; i++)
		dp[i][1]=1;
		for(int i=2; i<=n;i++)
			{
				for(int j=0; j<10; j++)
				{
					for(int k=j; k<10; k++)
					{
						dp[j][i]+=dp[k][i-1];
						dp[j][i]%=divide;
					}
				}
			}
			int sum(0);
			for(int i=0; i<10; i++)
				sum+=dp[i][n];
			int abcdef(sum%divide);
	return abcdef;
			
}
int main()
{
	cin>>n;
	cout<<jungin()<<endl;
}
