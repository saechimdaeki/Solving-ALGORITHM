#include<iostream>
#include<vector>
using namespace std;
int n;
vector<pair<int ,int > > v;

int solve(int idx) 
{
	if(idx==n)
	{
		int cnt(0);
		for(auto i:v)
			if(i.first<=0)
				cnt++;
		return cnt;
	}
	if(v[idx].first<=0)
		return solve(idx+1);
	bool isok(false);
	int ans(0);
	for(int i=0; i<n; i++)
	{
		if(idx==i)
		continue;
		if(v[i].first>0)
		{
			isok=true;
			v[idx].first-=v[i].second;
			v[i].first-=v[idx].second;
			int tmp(solve(idx+1));
			ans=max(ans,tmp);
			v[idx].first+=v[i].second;
			v[i].first+=v[idx].second;
		}
	}
	if(!isok)
		return solve(idx+1);
	return ans;	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i].first>>v[i].second;
	cout<<solve(0);
}
