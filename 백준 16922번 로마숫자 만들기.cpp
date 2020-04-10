#include<iostream>
#include<algorithm>
using namespace std;
bool checked[50*20+1];
int n,answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=n-i; j++)
		{
			for(int k=0; k<=n-i-j; k++)
			{
				int l=n-i-j-k;
				checked[i+5*j+10*k+50*l]=true;
			}
		}
	}
	for(int i=0; i<=50*20; i++)
	{
		if(checked[i])
		answer++;
	}
	cout<<answer;
}
