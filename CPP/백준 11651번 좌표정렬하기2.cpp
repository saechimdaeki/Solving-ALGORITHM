#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int n;
vector<pair<int, int > > v;
bool cmp(pair<int,int> &p1 , pair<int, int> &p2)
{
	if(p2.second>p1.second)
	return true;
	else if(p2.second==p1.second)
	return p2.first>p1.first;
	else
	return false;
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
	cout<<v[i].first<<' '<<v[i].second<<endl;
}
