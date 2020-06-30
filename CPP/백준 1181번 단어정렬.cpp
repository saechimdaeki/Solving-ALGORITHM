#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
string abc[20001];
bool cmp(string &s1, string &s2)
{
	if(s1.length()==s2.length())
	return s1<s2;
	return s1.length()<s2.length();
}
int main()
{
	int n;
	cin>>n;
	
	for(int i=1; i<=n; i++)
	cin>>abc[i];
	sort(abc+1,abc+n+1,cmp);
	for(int i=1; i<=n; i++)
	if(abc[i]!=abc[i+1])
	cout<<abc[i]<<"\n";
}
