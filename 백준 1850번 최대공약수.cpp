#include<iostream>
using namespace std;

double gcd(double n1, double n2)
{
	if(n2==0)
	return n1;
	gcd(n2,n1%n2);
}
int main()
{
	double a,b;
	cin>>a>>b;
	double c=gcd(a,b);
	for(int i=0; i<c; i++)
	{
		cout<<"1";
	}
}
