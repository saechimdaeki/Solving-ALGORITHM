#include<iostream>
#include<algorithm>
using namespace std;
string s;
int ans;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<s.length()-2; i++)
	{
		if(s[i]+1==s[i+1]&&s[i+1]+1==s[i+2])
		{
			if(i+3<s.length() &&(s[i+2]+1==s[i+3]))
			{
				while(i<s.length()-1 &&s[i]+1==s[i+1])
				i++;
			}
			else
			ans++;
		}
	}
	cout<<ans;
}
