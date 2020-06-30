#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,m;
vector<int> sang;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	sang.resize(n);
	for(int i=0; i<n; i++)
	cin>>sang[i];
	cin>>m;
	sort(sang.begin(),sang.end());
	for(int i=0; i<m; i++)
	{
		int a;
		cin>>a;
		cout<<upper_bound(sang.begin(),sang.end(),a)-lower_bound(sang.begin(),sang.end(),a)<<" ";
	}
	
	
}
