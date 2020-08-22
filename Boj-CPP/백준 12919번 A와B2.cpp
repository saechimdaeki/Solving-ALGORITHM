#include<iostream>
#include<algorithm>
using namespace std;
string s,t;
string cut(string s)
{
	s.pop_back();
	return s;
}
string rev(string s)
{
	reverse(s.begin(),s.end());
	return s;
}

bool solve(string s, string t)
{
	if(s==t)
	return true;
	if(t.length()>0)
	{
		if(t.back()=='A' && solve(s,cut(t)))
		return true;
		if(t[0]=='B'&&solve(s, cut(rev(t))))
		return true;
	}
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s>>t;
	cout<<solve(s,t);
}
