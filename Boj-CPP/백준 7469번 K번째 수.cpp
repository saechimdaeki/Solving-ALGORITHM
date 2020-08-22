#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,m;
vector<pair<int, int> > v;
int K(int a, int b, int c)
{
	int count(0);
	for(int i=0; i<n; i++)
	{
		if(a<=v[i].second && v[i].second<=b)
		count++;
		if(count==c)
		return v[i].first;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first;
		v[i].second=i+1;	
	}
	sort(v.begin(),v.end());
	for(int i=0; i<m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		cout<<K(a,b,c)<<endl;
	}
}
