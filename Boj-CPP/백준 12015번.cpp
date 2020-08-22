#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
int cnt;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	vector<int> list(n+1,123456789);	
	for(int i=0; i<n; i++)
	{
		int tmp=lower_bound(list.begin(),list.end(),v[i])-list.begin();
		list[tmp]=v[i];
	}
	for (int i=0; i<n; i++)
	{
		if(list[i]!=123456789)
		cnt++;
	}
	cout<<cnt;
}
