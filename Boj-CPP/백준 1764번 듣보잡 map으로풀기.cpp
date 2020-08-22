#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#define endl '\n'
using namespace std;
int n,m;
map<string, int > mp;
vector<string> v;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		cin>>s;
		mp[s]++;
	}
	for(int j=0; j<m; j++)
	{
		cin>>s;
		mp[s]++;
	}
	for(auto i: mp)
	{
		if(i.second==2)
			v.push_back(i.first);
	}
	sort(v.begin(),v.end());
	cout<<v.size()<<endl;
	for(auto i:v)
	cout<<i<<endl;
}
