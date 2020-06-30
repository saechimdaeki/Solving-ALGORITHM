#include<iostream>
#include<algorithm>
using namespace std;
string s;
int ioi,joi;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]=='I'&&s[i+1]=='O'&&s[i+2]=='I')
		ioi++;
		if(s[i]=='J'&&s[i+1]=='O'&&s[i+2]=='I')
		joi++;
	}
	cout<<joi<<"\n"<<ioi;
}
