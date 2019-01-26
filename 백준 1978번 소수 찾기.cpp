#include<iostream>
using namespace std;

int main()
{
	int a;
	int count(0);
	cin>>a;
	
	for(int i=0; i<a; i++)
	{
		int av;
		cin>>av;
		if(av>=2)
		{	int b(1);
			for(int j=2; j*j<=av; j++)
			{
				if(av%j==0)
				b=0;
			}
			count+=b;
		}
	}
	cout<<count;
}
