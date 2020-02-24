#include<iostream>
#define endl '\n'
using namespace std;
string s;
string seft,sight;
int lefti,righti;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<(s.length()/2); i++)
		seft+=s[i];
	for(int i=(s.length()/2); i<s.length(); i++)
		sight+=s[i];
	
	for(int i=0; i<seft.length(); i++)
			lefti+= (seft[i]-'0');	
	for(int i=0; i<sight.length(); i++)
			righti+=(sight[i]-'0');
	if(lefti==righti)
	cout<<"LUCKY";
	else
	cout<<"READY";

}
