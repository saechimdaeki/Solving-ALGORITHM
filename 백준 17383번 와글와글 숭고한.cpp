#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<pair<int, string> >v(3);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>v[0].first>>v[1].first>>v[2].first;
	v[0].second="Soongsil";
	v[1].second="Korea";
	v[2].second="Hanyang";
	if(v[0].first+v[1].first+v[2].first>=100)
	cout<<"OK";
	else
	{
		sort(v.begin(),v.end());
		cout<<v[0].second;
	}
}
