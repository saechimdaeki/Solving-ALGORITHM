#include<iostream>
#include<algorithm>
using namespace std;

int gcd(int a,int b)
{
	if(a<b)
	return gcd(b,a);
	if(b==0)
	return a;
	
	return gcd(b, a%b);
}

int main()
{
	int n;
	cin>>n;
	while(n--)
	{
		int a; int b;
		cin>>a>>b;
		int abc=gcd(a,b);
		cout<<(a/abc)*(b/abc)*abc<<endl;
	}
}
