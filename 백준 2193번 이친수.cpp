#include<iostream>
using namespace std;
long long dynamic[91][2];
int main()
{
	long long dynamic[91][2]={
		{0,0},{0,1},{1,2}
	};
	int n;
	cin>>n;
	for(int i=2; i<=n; i++)
	{
		dynamic[i][0]=dynamic[i-1][0]+dynamic[i-1][1];
		dynamic[i][1]=dynamic[i-1][0];
	}
	cout<<dynamic[n][0]+dynamic[n][1];
}
