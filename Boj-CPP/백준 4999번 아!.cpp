#include<iostream>
using namespace std;
string s1,s2;
int cnt1,cnt2;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s1>>s2;
	for(int i=0; i<s1.length(); i++)
	{
		if(s1[i]=='a')
			cnt1++;	
	}
	for(int i=0; i<s2.length(); i++)
	{
		if(s2[i]=='a')
			cnt2++;	
	}
	if(cnt1>=cnt2)
	cout<<"go";
	else
	cout<<"no";
	
}
