#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> v;
int n,k;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	
	sort(v.begin(),v.end());
	reverse(v.begin(),v.end());
	int result(0);
	for(int i=0; i<n; i++)
	{
		result+=k/v[i];
		k%=v[i];
	}
	cout<<result<<"\n";
}
