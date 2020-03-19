#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
vector<int> dp;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n); dp.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	for(int i=0; i<n; i++){
		dp[i]=1;
		for(int j=0; j<i; j++){
			if(v[j]<v[i]&& dp[j]+1>dp[i])
			dp[i]=dp[j]+1;
		}
	}
	cout<<*max_element(dp.begin(),dp.end());
}
