#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
using namespace std;
vector<int> v;
int n;
int sum,sum2;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
		sum+=v[i];
	}
	sum/=n;
	for(int i=0; i<n; i++)
	{
		if(sum>v[i])
		sum2+=sum-v[i];
		else
		sum2+=v[i]-sum;
	}
	cout<<sum2/2;
}
