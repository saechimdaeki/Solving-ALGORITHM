#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> v(3);

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<3; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	string s;
	cin>>s;
	for(int i=0; i<s.length();i++)
	{
		if(s[i]=='A')
		cout<<v[0]<<" ";
		else if(s[i]=='B')
		cout<<v[1]<<" ";
		else if(s[i]=='C')
		cout<<v[2]<<" "; 
	}
}
