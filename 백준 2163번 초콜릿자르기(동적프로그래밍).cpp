#include<iostream>
using namespace std;

int dynamic[300];

int dp(int a,int b)
{
	dynamic[1]=a-1;
	for(int i=2; i<=b; i++)
		dynamic[i]=dynamic[i-1]+a;
		
		return dynamic[b];
}

int main()
{
	int a,b;
	cin>>a>>b;
	cout<<dp(a,b);
}

