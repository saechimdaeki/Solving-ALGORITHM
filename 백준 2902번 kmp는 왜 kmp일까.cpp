#include<iostream>
#include<algorithm>
using namespace std;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	cout<<s[0];
	for(int i=1; i<s.length(); i++)
	{
		if(s[i]!='-')
		continue;
		else if(s[i]=='-'&&i+1<s.length())
		cout<<s[i+1];
	}
}
