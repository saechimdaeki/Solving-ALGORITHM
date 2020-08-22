#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;
int t,n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin>>s;
	bool check(true);
	for(int i=0; i<s.length(); i++)
	{
		if(s[i] != s[s.length()-1-i])
		{
			check=false;
			break;
		}	
	}
	if(check==true)
		cout<<"1";
	else
		cout<<"0";
}
