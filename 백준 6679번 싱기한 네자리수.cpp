#include<iostream>
#include<algorithm>
using namespace std;

int ten(int n1)
{
	int sum(0);
	while(n1>0)
	{
		sum+=n1%10;
		n1/=10;
	}
	return sum;
}
int twelve(int n1)
{
	int sum(0);
	while(n1>0)
	{
		sum+=n1%12;
		n1/=12;
	}
	return sum;
}
int sixteen(int n1)
{
		int sum(0);
	while(n1>0)
	{
		sum+=n1%16;
		n1/=16;
	}
	return sum;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=1000; i<=9999; i++)
	{
		if(ten(i)==twelve(i)&&twelve(i)==sixteen(i))
		cout<<i<<"\n";
	}
}
