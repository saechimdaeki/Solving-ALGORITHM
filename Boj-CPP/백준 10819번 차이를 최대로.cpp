#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
#define endl '\n'
using namespace std;
vector<int > v;
int n,ans;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	sort(v.begin(),v.end());
	do{
		int tmp(0);
		for(int i=0; i<n-1; i++)
		{
			tmp+=abs(v[i]-v[i+1]);
			ans=max(ans,tmp);
		}
	}while(next_permutation(v.begin(),v.end()));
	cout<<ans;

}

