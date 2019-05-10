#include<iostream>
using namespace std;

int main()
{
	string s;
	cin>>s;
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a, b;
		cin>>a>>b;
		swap(s[a],s[b]);
	}
	cout<<s;
}
