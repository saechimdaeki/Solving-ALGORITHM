#include<iostream>
#include<algorithm>
using namespace std;
string s,t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s>>t;
	while(t.length()>s.length())
	{
		if(t.back()=='A')
		t.pop_back();
		else{
			t.pop_back();
			reverse(t.begin(),t.end());
		}
	}
	if(s==t)
	cout<<1;
	else
	cout<<0;
}
