#include<iostream>
using namespace std;

int dynamic[1001];

int dp(int x)
{
	if(x==1)
	return 1;
	if(x==2)
	return 2;
	if(dynamic[x]!=0)
	return dynamic[x];
	return dynamic[x]=(dp(x-1)+dp(x-2))%10007;
}

int main()
{
	int x;
	cin>>x;
	cout<<dp(x)<<endl;
}
