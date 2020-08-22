#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<pair<long long,long long > > v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i].second;
		long long tmp=v[i].second;
		while(tmp%3==0)
		{
			tmp/=3;
			v[i].first++;
		}
		v[i].first=-v[i].first;
		
	}
	
	
	sort(v.begin(),v.end());
	for(auto i:v)
	cout<<i.second<<' ';
}

