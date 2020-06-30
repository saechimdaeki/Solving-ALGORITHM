#include<iostream>
using namespace std;

int dynamic[1001];

int dp(int x)
{
	if(x==1)
	return 1;
	if(x==2)
	return 3;
	if(dynamic[x]!=0)
	return dynamic[x];
	
	
	return dynamic[x]=(dp(x-1)+ 2*dp(x-2))%10007;
}

int main()
{
	int n;
	cin>>n;
	cout<<dp(n)<<endl;
}

