#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		string s;
		cin>>s;
		for(int j=0; j<a; j++)
		cout<<s;
		cout<<"\n";
	}
}
