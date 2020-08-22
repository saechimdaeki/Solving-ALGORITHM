#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> v;

int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n+m);
	for(int i=0; i<n+m; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<n+m; i++)
	cout<<v[i]<<" ";
	
}
