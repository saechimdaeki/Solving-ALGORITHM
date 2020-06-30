#include<iostream>
#include<algorithm>
#include<functional>
#include<vector>
using namespace std;

int n;
vector<pair < int , int > > v;
int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
		
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first>>v[i].second;
	}
	sort(v.begin(),v.end());	
	for(int i=0; i<v.size(); i++)
	{
		cout<<v[i].first<<" "<<v[i].second<<"\n";
	}
	
}


