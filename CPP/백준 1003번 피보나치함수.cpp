#include<iostream>
using namespace std;

int fibo[43]={1,0,1};
int main()
{
	
	int n,n2;
	for(int i=3; i<42; i++)
	{
		fibo[i]=fibo[i-2]+fibo[i-1];
	}
		cin>>n;
		for(int i2=0; i2<n; i2++)
		{
			cin>>n2;
			cout<<fibo[n2]<<" "<<fibo[n2+1]<<"\n";
		}
	
}

