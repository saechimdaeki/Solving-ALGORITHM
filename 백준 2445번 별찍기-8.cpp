#include<iostream>
using namespace std;

int main()
{
	int n;
	cin>>n;
	
	for(int i=1; i<=n; i++)
	{
		for(int a=1; a<=i; a++)
		cout<<"*";
		for(int a=1; a<=n*2-i*2; a++)
		cout<<" ";
		for(int a=1; a<=i; a++)
		cout<<"*";
		cout<<endl;
	}
	for(int i=1; i<n; i++)
	{
		for(int a=1; a<=n-i; a++)
		cout<<"*";
		for(int a=1; a<=i*2; a++)
		cout<<" ";
		for(int a=1; a<=n-i; a++)
		cout<<"*";
		cout<<endl;
	}
}
