#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<n; i++)
	cout<<v[i]<<" ";
}
