#include<iostream>
#include<cmath>
using namespace std;

int sosoo(int n)
{
	if(n==1)
	return 0;
	int a=(int)sqrt(n);
	for(int i=2; i<=a; i++)
	{
		if(n%i==0)
		return 0;
	}
	return 1;
}

int main()
{
	int a,b;
	cin>>a>>b;
	for(int i=a; i<=b; i++)
	{
		if(sosoo(i)==1)
		cout<<i<<"\n";
	}
}
