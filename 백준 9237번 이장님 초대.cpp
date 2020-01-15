#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n;
vector<int> v; 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	sort(v.rbegin(),v.rend());
	int cnt(2),maxv(0);
	for(int i=0; i<v.size(); i++)
	{
		v[i]+=cnt;
		cnt++;
		maxv=max(maxv,v[i]);
	}
	cout<<maxv;
}
