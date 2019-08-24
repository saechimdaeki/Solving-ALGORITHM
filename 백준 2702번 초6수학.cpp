#include<iostream>
#include<cmath>
#define endl '\n'
using namespace std;
int t;
int gcd(int a,int b)
{
	if(b==0)
	return a;
	return gcd(b,a%b);
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int n1,n2;
		cin>>n1>>n2;
		cout<<n1*n2/gcd(n1,n2)<<" "<<gcd(n1,n2)<<endl;
	}
}
