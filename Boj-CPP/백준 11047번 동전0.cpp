#include<iostream>
#include<vector>
#include<algorithm>
using namespace std; 
int n,k,cnt;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	sort(v.rbegin(),v.rend());
	for(int i=0; i<n; i++)
	{
		cnt+=k/v[i];
		k%=v[i];	
	}
	cout<<cnt;	
}
