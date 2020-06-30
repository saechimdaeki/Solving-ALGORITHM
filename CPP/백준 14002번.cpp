#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n;
vector<int> v;
vector<int> list;
vector<int> dp;
int cnt;
void backtrack(int n1){
	if(n1==-1)
	return;
	backtrack(list[n1]);
	cout<<v[n1]<<' ';
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n); dp.resize(n); list.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	for(int i=0; i<n; i++){
		dp[i]=1;
		list[i]=-1;
		for(int j=0; j<i; j++){
			if(v[j]<v[i]&& dp[j]+1>dp[i]){
			dp[i]=dp[j]+1;
			list[i]=j;
			}
		}
	}
	int answer=dp[0];
	for(int i=0; i<n; i++)
	{
		if(answer<dp[i]){
			answer=dp[i];
			cnt=i;
		}
	}
	cout<<*max_element(dp.begin(),dp.end())<<endl;
	backtrack(cnt);
}
