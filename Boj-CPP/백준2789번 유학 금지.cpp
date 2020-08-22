#include<iostream>
#include<algorithm>
using namespace std;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='C'||s[i]=='A'||s[i]=='M'||s[i]=='B'||s[i]=='R'|| \
		s[i]=='I'||s[i]=='D'||s[i]=='G'||s[i]=='E')
		;
		else
		cout<<s[i];
	}

}
