#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=1; i<=n; i++)
	{
		cin>>s;
		cout<<"String #"<<i<<"\n";
		for(int j=0; j<s.length();j++)
		{
			if(s[j]==90)
			cout<<"A";
			else
			cout<<(char)(s[j]+1);
		}
		cout<<"\n";
		cout<<"\n";
	}
}
