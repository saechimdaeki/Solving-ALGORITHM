#include<iostream>
#include<functional>
#include<algorithm>
using namespace std;

int n;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	int start(666);
	int num(1);
	while(true)
	{
		if(num==n)
		goto z;
		start++;
		int copys(start);
		int count123(0);
		while(copys)
		{
			int tmp(copys%10);
			if(tmp==6)
			count123++;
			else if(count123 <3 )
			count123=0;
			copys/=10;
		}
		if(count123>=3)
		num++;
	}
	z:
		cout<<start;
 } 
