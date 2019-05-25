#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;
int n;
vector<pair<int , int> >v;
int count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first;
		v[i].second=i;
	}
	sort(v.begin(),v.end());
	
	for(int i=0; i<n; i++)
	count123=max(count123,v[i].second-i);
	
	cout<<count123+1<<"\n";
}

