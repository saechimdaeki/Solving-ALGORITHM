#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main()
{
	while(1)
	{
		int a,b,c;
		cin>>a>>b>>c;
		if(a==0&&b==0&&c==0)
		return 0;
		if(a*a==b*b+c*c||b*b==a*a+c*c||c*c==b*b+a*a)
		cout<<"right\n";
		else
		cout<<"wrong\n";
	}

}
