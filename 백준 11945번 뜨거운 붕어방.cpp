#include<iostream>
#include<algorithm>
using namespace std;
int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		reverse(s.begin(),s.end());
		cout<<s<<"\n";
	}
}
