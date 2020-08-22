#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int t,n;


bool cmp(pair<string,int> &p1, pair<string, int> &p2)
{
	return p1.second<p2.second;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		cin>>n;
		vector<pair<string,int>> v(n);
		for(int j=0; j<n; j++)
		{
			cin>>v[j].first>>v[j].second;
		}
		
		sort(v.begin(),v.end(),cmp);
		cout<<v[n-1].first<<endl;		
	}
}
