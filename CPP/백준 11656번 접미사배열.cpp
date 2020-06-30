#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'

using namespace std;
string s;
vector<string> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	
	for(int i=0; i<s.length();i++)
	{
		v.push_back(s.substr(i,s.length()));
			
	}
	sort(v.begin(),v.end());
	for(int i=0; i<s.length(); i++)
	{
		cout<<v[i]<<endl;
	}
	
}
