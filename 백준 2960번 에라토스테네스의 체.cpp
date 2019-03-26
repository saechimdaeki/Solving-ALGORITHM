#include<iostream>
#include<cmath>
using namespace std;

int sosoo(int n)
{
	
	if(n==1)
	return 0;
	int m=(int)sqrt(n);
	for(int i=2; i<m; i++)
	{
		if(n%i==0)
		return 0;
		
	}
	return 1;
}

int main()
{
	int n,k;
	cin>>n>>k;
	for(int i=k; i<n; i++)
	{
		if(sosoo(i)==1)
		cout<<i<<endl;	
	}
	
}
