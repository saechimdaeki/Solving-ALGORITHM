#include<iostream>
#include<algorithm>
using namespace std;
int n; 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	while(1)
	{
		int a;
		cin>>a;
		if(a==0)
		return 0;
		if(a%n==0)
		cout<<a<<" "<<"is a multiple of "<<n<<".\n";
		else
		cout<<a<<" "<<"is NOT a multiple of "<<n<<".\n";
		
	}
}
