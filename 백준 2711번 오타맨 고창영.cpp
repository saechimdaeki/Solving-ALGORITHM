#include<iostream>
#include<functional>
using namespace std;
int t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int a;
		string s;
		cin>>a>>s;
		for(int i=0; i<s.length();i++)
		{
			if(i!=a-1)
			cout<<s[i];
		}
		cout<<"\n";
	}
}
