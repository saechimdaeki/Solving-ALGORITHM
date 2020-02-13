#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
int n,l;
int cnt(1);
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>l;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	sort(v.begin(),v.end());
	int tmp(v[0]);
	for(int i=1; i<n; i++)
	{
		if(v[i]-tmp>l)
		{
			cnt++;
			tmp=v[i];		
		}	
	}
	cout<<cnt; 
}
