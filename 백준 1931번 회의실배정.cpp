#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,time,cnt;
vector<pair<int, int> > v;
bool cmp(pair<int, int> &p1 , pair<int,int> &p2)
{
	if(p1.second==p2.second)
	{
		return p1.first<p2.first;
	}else{
		return p1.second<p2.second;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i].first>>v[i].second;
	sort(v.begin(),v.end(),cmp);
	for(int i=0; i<n; i++)
	{
		if(time<=v[i].first)
		{
			time=v[i].second;
			cnt++;
		}
	}
	cout<<cnt;
}
