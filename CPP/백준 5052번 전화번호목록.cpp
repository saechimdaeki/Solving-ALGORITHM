#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;
int t,n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		int check(1);
		cin>>n;
		vector<string> s(n);
		for(int i=0; i<n; i++)
		{
			cin>>s[i];
		}
		sort(s.begin(),s.end());
		
		for(int i=1; i<s.size(); i++)
		{
			if(s[i-1]==s[i].substr(0,s[i-1].size()))
			{
				check=0;
				break;
			}
		}
		if(check==1)
		cout<<"YES"<<"\n";
		else
		cout<<"NO"<<"\n";
	}
}
