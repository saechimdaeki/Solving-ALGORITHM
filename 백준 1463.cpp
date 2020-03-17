#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.reserve(1000000);
	cin>>n;
	for(int i=2; i<=n; i++)
	{
		v[i]=v[i-1]+1;
		if(i%2==0)
		v[i]=min(v[i],v[i/2]+1);
		if(i%3==0)
		v[i]=min(v[i],v[i/3]+1);
	}
	cout<<v[n];
}
