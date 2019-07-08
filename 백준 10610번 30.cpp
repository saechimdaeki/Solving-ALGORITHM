#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

string s;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	int sum(0);
	for(char c: s)
	sum+=c-'0';
	sort(s.begin(),s.end());
	if(s[0]=='0'&&sum%3==0)
	{
		reverse(s.begin(),s.end());
		cout<<s;
	}
	else
	cout<<"-1";
} 
