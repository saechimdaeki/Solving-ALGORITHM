#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;

vector<pair <int , int > > v;
int n;
bool greatorrrrr(pair<int , int> p1, pair<int , int> p2)
{
	if(p1.second<p2.second)
	return true;
	else if(p1.second==p2.second)
	{
		if(p1.first<p2.first)
		return true;
	}
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
	
	sort(v.begin(),v.end(),greatorrrrr);
	
	for(int i=0; i<n; i++)
	cout<<v[i].first<<" "<<v[i].second<<"\n";
	return 0;
	
	
	
}
