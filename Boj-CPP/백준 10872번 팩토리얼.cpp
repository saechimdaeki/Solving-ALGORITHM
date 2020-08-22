#include<iostream>
using namespace std;

int n;

int fact(int n)
{
	int f(1);
	for(int i=1; i<=n; i++)
	{
		f*=i;
	 } 
	 return f;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cout<<fact(n);
}
