#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n;
	for(int i=1; i<=n; i++)
	{
		for(int k=1; k<=i-1; k++)
		{
			cout<<" ";
		}
		for(int a=1; a<=2*n-(i-1)*2-1; a++)
		{
			cout<<"*";
		}
		cout<<"\n";
	}
	for(int c=2; c<=n; c++)
	{
		for(int d=1; d<=n-c; d++)
		{
			cout<<" ";
		}
		for(int f=1; f<=2*c-1; f++)
		{
			cout<<"*";
		}
		cout<<"\n";
	}
 } 
