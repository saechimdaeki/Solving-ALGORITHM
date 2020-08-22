#include<iostream>
#include<algorithm>
using namespace std;
string s;
int answer,tmp;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<s.length(); i++)
	tmp+=(s[i]-'0');
	sort(s.begin(),s.end());
	if(tmp%3==0 && s[0]=='0')
	{
		reverse(s.begin(),s.end());
		cout<<s;
	}else
	cout<<-1;
	
}
