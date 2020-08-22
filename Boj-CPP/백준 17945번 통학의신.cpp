#include<iostream>
#include<cmath>
using namespace std;
int a,b,ea;
double x1,x2;
///// x^2 +2ax+b=0
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b;
	ea=2*a;
	double d(ea*ea-4*b);
	if(d>0)
	{
		x1=(-ea-sqrt(ea*ea-4*b))/2;
		x2=(-ea+sqrt(ea*ea-4*b))/2;
		cout<<x1<<' '<<x2;
	}
	else if(d==0)
	{
		x1=ea/(-2);
		cout<<x1;
	}
}
	
