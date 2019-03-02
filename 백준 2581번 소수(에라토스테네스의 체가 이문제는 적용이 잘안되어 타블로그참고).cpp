#include<iostream>
using namespace std;

int main()
{
	int m,n,count(0),sum(0),maximum(100001);
	cin>>m>>n;
	for(int i=m; i<=n; i++)
	{
		for(int a=2; a<i; a++)
		{
			if(i%a==0)
			count++;
		}
		if(count==0 && i!=1)
		{
			sum+=i;
			if(maximum>i)
			maximum=i;
		}
		count=0;
	}
	if(maximum==100001)
	cout<<"-1\n";
	else
	cout<<sum<<"\n"<<maximum<<"\n";
}
