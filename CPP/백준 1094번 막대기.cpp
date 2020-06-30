#include<iostream>
using namespace std;

int main()
{
	int x;
	cin>>x;
	int bts(0);
	int sum(0);
	for(int i=64; i>0; i/=2)
	{
		if(i>x)
		continue;
		else if(sum+i<=x)
		{
			sum+=i;
			bts++;
		}
		else if(i==x)
		{
			bts=1;
			break;
		}
	
	}
	cout<<bts;
}
