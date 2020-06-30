#include<iostream>
#include<algorithm>
using namespace std;

string s;
int sum(10);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=1;i<s.length();i++)
	{
		if(s[i-1]==s[i])
		sum+=5;
		else
		sum+=10;	
	}
	cout<<sum;
}
