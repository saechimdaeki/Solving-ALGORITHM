#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;
vector<string> v;
int n;
int cmp(string s1,string s2)
{
	if(s1.length()<s2.length())
	return s1.length()<s2.length();
	else if(s1.length()==s2.length())
	{
		int s1sum(0),s2sum(0);
		for(int i=0; i<s1.length(); i++)
			if('0'<=s1[i]&&s1[i]<='9')
			s1sum=s1sum+(s1[i]-'0');
		for(int i=0; i<s2.length(); i++)
		if('0'<=s2[i]&&s2[i]<='9')
			s2sum=s2sum+(s2[i]-'0');
		if(s1sum<s2sum)
		return 1;
		else if(s1sum==s2sum)
		{
			return s1<s2;
		}
		else
		return 0;
	}
	return 0;
 } 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];	
	sort(v.begin(),v.end(),cmp);
	for(int i=0; i<n; i++)
	cout<<v[i]<<"\n";
}
